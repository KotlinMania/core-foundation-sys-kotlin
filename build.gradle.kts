import java.io.ByteArrayInputStream
import java.net.URI
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.zip.ZipInputStream
import org.gradle.api.GradleException
import org.gradle.api.tasks.ClasspathNormalizer
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.testing.AbstractTestTask
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.support.serviceOf
import org.gradle.process.ExecOperations
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsEnvSpec
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootEnvSpec
import org.jetbrains.kotlin.gradle.targets.wasm.nodejs.WasmNodeJsEnvSpec
import org.jetbrains.kotlin.gradle.targets.wasm.yarn.WasmYarnRootEnvSpec

plugins {
    kotlin("multiplatform") version "2.3.21"
    id("com.vanniktech.maven.publish") version "0.36.0"
}

// kotlin("plugin.serialization") and id("com.android.kotlin.multiplatform.library")
// are intentionally absent — Apple-only target surface (see kotlin{} block) means
// no Android KMP library target is declared, and there are no serialization-using
// sources to compile.

group = "io.github.kotlinmania"
version = "0.1.1"

val androidCommandLineToolsRevision = "14742923"
val projectCompileSdk = "34"
val projectAndroidBuildTools = "36.0.0"
val isWindowsHost = System.getProperty("os.name").lowercase().contains("windows")
val androidSdkOsName =
    when {
        isWindowsHost -> "win"
        System.getProperty("os.name").lowercase().contains("mac") -> "mac"
        System.getProperty("os.name").lowercase().contains("linux") -> "linux"
        else -> throw GradleException("Unsupported Android SDK setup OS: ${System.getProperty("os.name")}")
    }
val projectAndroidSdkDir = layout.projectDirectory.dir(".android-sdk").asFile
val androidSdkManager = projectAndroidSdkDir.resolve(
    if (isWindowsHost) {
        "cmdline-tools/latest/bin/sdkmanager.bat"
    } else {
        "cmdline-tools/latest/bin/sdkmanager"
    },
)
val androidSdkInstallMarker = projectAndroidSdkDir.resolve(".install-complete")
val requiredAndroidSdkPackageDirs = listOf(
    projectAndroidSdkDir.resolve("platform-tools"),
    projectAndroidSdkDir.resolve("platforms/android-$projectCompileSdk"),
    projectAndroidSdkDir.resolve("build-tools/$projectAndroidBuildTools"),
)

fun isProjectAndroidSdkInstalled(): Boolean =
    androidSdkInstallMarker.exists() &&
        androidSdkManager.exists() &&
        requiredAndroidSdkPackageDirs.all { it.exists() }

fun writeAndroidLocalProperties() {
    val sdkDirPropertyValue = projectAndroidSdkDir.absolutePath.replace("\\", "/")
    layout.projectDirectory.file("local.properties").asFile.writeText("sdk.dir=$sdkDirPropertyValue\n")
}

fun sdkManagerCommand(vararg args: String): List<String> =
    if (isWindowsHost) {
        listOf("cmd", "/c", androidSdkManager.absolutePath) + args
    } else {
        listOf(androidSdkManager.absolutePath) + args
    }

fun downloadAndroidCommandLineTools() {
    val zipName = "commandlinetools-$androidSdkOsName-${androidCommandLineToolsRevision}_latest.zip"
    val url = "https://dl.google.com/android/repository/$zipName"
    val tmpDir = projectAndroidSdkDir.resolve(".tmp/commandline-tools")
    val zipFile = tmpDir.resolve(zipName)
    val latestDir = projectAndroidSdkDir.resolve("cmdline-tools/latest")

    println("setup-android-sdk: downloading $url")
    tmpDir.deleteRecursively()
    tmpDir.mkdirs()

    try {
        URI(url).toURL().openStream().use { input ->
            Files.copy(input, zipFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
        }

        latestDir.deleteRecursively()
        latestDir.mkdirs()
        val canonicalLatestDir = latestDir.canonicalFile.toPath()

        ZipInputStream(zipFile.inputStream().buffered()).use { zipInput ->
            generateSequence { zipInput.nextEntry }.forEach { entry ->
                val relativeName = entry.name.removePrefix("cmdline-tools/").trimStart('/')
                if (relativeName.isNotEmpty()) {
                    val target = latestDir.resolve(relativeName).canonicalFile
                    if (!target.toPath().startsWith(canonicalLatestDir)) {
                        throw GradleException("Refusing to extract Android SDK entry outside $latestDir: ${entry.name}")
                    }
                    if (entry.isDirectory) {
                        target.mkdirs()
                    } else {
                        target.parentFile.mkdirs()
                        Files.copy(zipInput, target.toPath(), StandardCopyOption.REPLACE_EXISTING)
                        if (!isWindowsHost && relativeName.startsWith("bin/")) {
                            target.setExecutable(true)
                        }
                    }
                }
                zipInput.closeEntry()
            }
        }

        if (!isWindowsHost) {
            androidSdkManager.setExecutable(true)
        }
    } finally {
        tmpDir.deleteRecursively()
    }
}

fun installProjectAndroidSdk(execOperations: ExecOperations) {
    if (isProjectAndroidSdkInstalled()) {
        writeAndroidLocalProperties()
        println("setup-android-sdk: SDK already installed at $projectAndroidSdkDir")
        return
    }

    if (!androidSdkManager.exists()) {
        downloadAndroidCommandLineTools()
    }

    println("setup-android-sdk: accepting licenses")
    val licenseAnswers = "y\n".repeat(200).toByteArray(Charsets.UTF_8)
    val licenseResult = execOperations.exec {
        commandLine(sdkManagerCommand("--sdk_root=${projectAndroidSdkDir.absolutePath}", "--licenses"))
        standardInput = ByteArrayInputStream(licenseAnswers)
        isIgnoreExitValue = true
    }
    if (licenseResult.exitValue != 0) {
        throw GradleException("Android SDK license acceptance failed with exit code ${licenseResult.exitValue}")
    }

    println("setup-android-sdk: installing platform-tools, android-$projectCompileSdk, build-tools;$projectAndroidBuildTools")
    val installLog = projectAndroidSdkDir.resolve("sdkmanager-install.log")
    installLog.parentFile.mkdirs()
    installLog.outputStream().use { output ->
        val installResult = execOperations.exec {
            commandLine(
                sdkManagerCommand(
                    "--sdk_root=${projectAndroidSdkDir.absolutePath}",
                    "platform-tools",
                    "platforms;android-$projectCompileSdk",
                    "build-tools;$projectAndroidBuildTools",
                ),
            )
            standardOutput = output
            errorOutput = output
            isIgnoreExitValue = true
        }
        if (installResult.exitValue != 0) {
            throw GradleException(
                "Android SDK package install failed with exit code ${installResult.exitValue}. " +
                    "Install log:\n${installLog.readText()}",
            )
        }
    }
    println("setup-android-sdk: install log at $installLog")

    writeAndroidLocalProperties()
    androidSdkInstallMarker.writeText("")
    println("setup-android-sdk: done")
    println("  SDK at:     $projectAndroidSdkDir")
    println("  configured: local.properties -> $projectAndroidSdkDir")
}

// The Android Gradle plugin resolves the SDK location while Gradle builds the
// task graph, before any task executes, so a project-local Android SDK must
// already be installed by the time configuration reaches the android target.
// This configuration-time installer is idempotent and always writes
// local.properties to this repo's own .android-sdk path.
val androidSdkExecOperations = serviceOf<ExecOperations>()
installProjectAndroidSdk(androidSdkExecOperations)

kotlin {
    applyDefaultHierarchyTemplate()

    sourceSets.all {
        languageSettings.optIn("kotlin.time.ExperimentalTime")
        languageSettings.optIn("kotlin.concurrent.atomics.ExperimentalAtomicApi")
        languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
    }

    compilerOptions {
        allWarningsAsErrors.set(true)
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    val xcf = XCFramework("CoreFoundationSys")

    macosArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    iosArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    iosSimulatorArm64 {
        binaries.framework {
            baseName = "CoreFoundationSys"
            isStatic = true
            xcf.add(this)
        }
    }
    iosX64 {
        // iOS Simulator targets share an XCFramework "fat" stage that
        // requires every input framework to be either all static or all
        // dynamic. iosSimulatorArm64 is already declared static for the
        // Swift Export SPM bridge, so iosX64 must match.
        binaries.framework {
            baseName = "CoreFoundationSys"
            isStatic = true
            xcf.add(this)
        }
    }

    tvosArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    tvosSimulatorArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    watchosArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    watchosDeviceArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }
    watchosSimulatorArm64 {
        binaries.framework { baseName = "CoreFoundationSys"; xcf.add(this) }
    }

    // Apple-only impossibility for the non-Apple standard KMP target
    // surface (jvm, android, js, wasmJs, wasmWasi, linuxX64, linuxArm64,
    // mingwX64, androidNativeArm32/Arm64/X86/X64). The upstream Rust
    // crate `core-foundation-sys` is pulled in only under
    // `[target.'cfg(target_vendor = "apple")'.dependencies]`; CoreFoundation
    // is a private Apple framework with no implementation off-Apple, and
    // Kotlin/Native's `platform.CoreFoundation.*` bindings only exist
    // for Apple targets. There is no kotlinmania sibling that could
    // bridge those symbols on a non-Apple host. Per workspace AGENTS.md
    // §5.4 ("Targets you must NEVER remove ... unless the repo-local
    // docs explicitly document the technical impossibility"), the
    // non-Apple targets are intentionally not declared here. See README
    // "Apple-only" section for the full rationale.

    swiftExport {
        moduleName = "CoreFoundationSys"
        flattenPackage = "io.github.kotlinmania.corefoundationsys"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

    }
    jvmToolchain(21)
}

tasks.withType<AbstractTestTask>().configureEach {
    testLogging {
        events(
            TestLogEvent.STARTED,
            TestLogEvent.PASSED,
            TestLogEvent.SKIPPED,
            TestLogEvent.FAILED,
            TestLogEvent.STANDARD_OUT,
            TestLogEvent.STANDARD_ERROR,
        )
        exceptionFormat = TestExceptionFormat.FULL
        showCauses = true
        showExceptions = true
        showStackTraces = true
        showStandardStreams = true
    }
}

// Kotlin/JS + Wasm-WASI toolchain configuration is intentionally absent —
// this repo has no `js {}`, `wasmJs {}`, or `wasmWasi {}` targets (per
// the Apple-only impossibility in the kotlin{} block), so the
// `kotlinNodeJsSpec`, `kotlinWasmNodeJsSpec`, `kotlinYarnSpec`,
// `kotlinWasmYarnSpec`, `kotlinYarn`, and `kotlinNodeJs` rootProject
// extensions are never registered. Trying to configure them produces
// "Extension with name 'kotlinNodeJsSpec' does not exist."

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(group.toString(), "core-foundation-sys-kotlin", version.toString())

    pom {
        name.set("core-foundation-sys-kotlin")
        description.set("Kotlin Multiplatform port of strawlab/iana-time-zone - get the IANA time zone for the current system")
        inceptionYear.set("2026")
        url.set("https://github.com/KotlinMania/iana-time-zone-kotlin")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("sydneyrenee")
                name.set("Sydney Renee")
                email.set("sydney@solace.ofharmony.ai")
                url.set("https://github.com/sydneyrenee")
            }
        }

        scm {
            url.set("https://github.com/KotlinMania/iana-time-zone-kotlin")
            connection.set("scm:git:git://github.com/KotlinMania/iana-time-zone-kotlin.git")
            developerConnection.set("scm:git:ssh://github.com/KotlinMania/iana-time-zone-kotlin.git")
        }
    }
}

// ---------------------------------------------------------------------------
// CodeQL Java/Kotlin extraction task
//
// .github/workflows/codeql.yml invokes `./gradlew codeqlCompileJvm` to feed
// kotlinc-compiled commonMain and Android sources through the CodeQL Java agent.
val codeqlKotlinc: Configuration by configurations.creating {
    description = "Kotlin compiler (CodeQL extraction target only - not published)"
    isCanBeResolved = true
    isCanBeConsumed = false
}

val codeqlSourceClasspath: Configuration by configurations.creating {
    description = "Runtime classpath for CodeQL extraction of commonMain and androidMain sources"
    isCanBeResolved = true
    isCanBeConsumed = false
}

val codeqlAndroidAar: Configuration by configurations.creating {
    description = "Android AAR artifacts for CodeQL classpath extraction (classes.jar only)"
    isCanBeResolved = true
    isCanBeConsumed = false
}

dependencies {
    codeqlKotlinc("org.jetbrains.kotlin:kotlin-compiler-embeddable:2.3.21")
    codeqlSourceClasspath("org.jetbrains.kotlin:kotlin-stdlib:2.3.21")
    codeqlSourceClasspath("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.11.0")
    codeqlSourceClasspath("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.11.0")
    codeqlSourceClasspath("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.11.0")
    codeqlSourceClasspath("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.8.0")
    codeqlSourceClasspath("org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:0.4.0")
    codeqlSourceClasspath("io.github.kotlinmania:android-system-properties-kotlin:0.1.0")
}

val codeqlCompileJvm = tasks.register<JavaExec>("codeqlCompileJvm") {
    description =
        "Compile commonMain and androidMain Kotlin sources with kotlinc 2.3.21 for CodeQL Java/Kotlin extraction."
    group = "verification"

    dependsOn("setupAndroidSdk")
    classpath(codeqlKotlinc)
    mainClass.set("org.jetbrains.kotlin.cli.jvm.K2JVMCompiler")

    val outDir = layout.buildDirectory.dir("classes/kotlin/codeql-jvm")
    val aarExtractDir = layout.buildDirectory.dir("codeql/android-aar")
    val commonSources = fileTree("src/commonMain/kotlin") { include("**/*.kt") }
    val androidSources = fileTree("src/androidMain/kotlin") { include("**/*.kt") }
    val sources = files(commonSources, androidSources)
    val sentinelDir = layout.buildDirectory.dir("generated/codeql-empty-source")
    inputs.files(sources).withPathSensitivity(PathSensitivity.RELATIVE)
    inputs.files(codeqlSourceClasspath).withNormalizer(ClasspathNormalizer::class.java)
    inputs.files(codeqlAndroidAar).withNormalizer(ClasspathNormalizer::class.java)
    outputs.dir(outDir)
    outputs.dir(aarExtractDir)
    outputs.dir(sentinelDir)

    doFirst {
        outDir.get().asFile.mkdirs()
        val extractedJars = mutableListOf<File>()
        for (aar in codeqlAndroidAar.resolve()) {
            val extractTarget = aarExtractDir.get().asFile.resolve(aar.nameWithoutExtension)
            extractTarget.mkdirs()
            copy {
                from(zipTree(aar))
                include("classes.jar")
                into(extractTarget)
            }
            val classesJar = extractTarget.resolve("classes.jar")
            if (classesJar.exists()) {
                extractedJars += classesJar
            }
        }

        val androidJar = projectAndroidSdkDir.resolve("platforms/android-$projectCompileSdk/android.jar")
        if (!androidJar.exists()) {
            throw GradleException("Android platform jar not found at $androidJar; run setupAndroidSdk first.")
        }

        val fullClasspath =
            (codeqlSourceClasspath.resolve() + extractedJars + androidJar)
                .joinToString(File.pathSeparator) { it.absolutePath }
        val commonSourceFiles = commonSources.files.toMutableList()
        val sourceFiles = sources.files.toMutableList()
        if (sourceFiles.isEmpty()) {
            val sentinelFile = sentinelDir.get().asFile.resolve(
                "io/github/kotlinmania/ianatimezone/codeql/_CodeqlEmptySource.kt",
            )
            sentinelFile.parentFile.mkdirs()
            sentinelFile.writeText(
                """
                // Auto-generated. Present so codeqlCompileJvm has at least
                // one Kotlin source to feed kotlinc; replaced by real
                // commonMain content once porting begins.
                package io.github.kotlinmania.corefoundationsys.codeql

                private object _CodeqlEmptySource
                """.trimIndent(),
            )
            commonSourceFiles += sentinelFile
            sourceFiles += sentinelFile
        }
        args = listOf(
            "-d", outDir.get().asFile.absolutePath,
            "-classpath", fullClasspath,
            "-jvm-target", "21",
            "-no-stdlib",
            "-no-reflect",
            "-language-version", "2.3",
            "-api-version", "2.3",
            "-Xmulti-platform",
            "-Xcommon-sources=${commonSourceFiles.joinToString(",") { it.absolutePath }}",
            "-Xexpect-actual-classes",
            "-opt-in", "kotlin.time.ExperimentalTime",
            "-opt-in", "kotlin.concurrent.atomics.ExperimentalAtomicApi",
            "-opt-in", "kotlin.ExperimentalUnsignedTypes",
        ) + sourceFiles.map { it.absolutePath }
    }
}

tasks.register("setupAndroidSdk") {
    group = "setup"
    description = "Downloads and configures the project-local Android SDK."
    doLast {
        installProjectAndroidSdk(androidSdkExecOperations)
    }
}

tasks.register("test") {
    group = "verification"
    description =
        "Runs the host-portable test suite (macOS + JS + WasmJS + Android unit). " +
        "Non-host native targets (mingwX64, linuxX64) only run on their own host."

    val defaultTestTasks = listOf(
        "macosArm64Test",
        "jvmTest",
        "jsNodeTest",
        "wasmJsNodeTest",
        "compileAndroidMain",
        "assembleUnitTest",
    )

    dependsOn(defaultTestTasks.mapNotNull { taskName -> tasks.findByName(taskName) })
}

val fullTargetBuildTaskNames = setOf(
    // Apple-only target surface — see kotlin{} block + README for the
    // CoreFoundation impossibility rationale on the non-Apple targets.
    "iosArm64Binaries",
    "iosArm64TestBinaries",
    "iosSimulatorArm64Binaries",
    "iosSimulatorArm64TestBinaries",
    "iosX64Binaries",
    "iosX64TestBinaries",
    "macosArm64Binaries",
    "macosArm64TestBinaries",
    "tvosArm64Binaries",
    "tvosArm64TestBinaries",
    "tvosSimulatorArm64Binaries",
    "tvosSimulatorArm64TestBinaries",
    "watchosArm64Binaries",
    "watchosArm64TestBinaries",
    "watchosDeviceArm64Binaries",
    "watchosDeviceArm64TestBinaries",
    "watchosSimulatorArm64Binaries",
    "watchosSimulatorArm64TestBinaries",
    "assembleCoreFoundationSysXCFramework",
)

tasks.named("build") {
    dependsOn(fullTargetBuildTaskNames)
}

afterEvaluate {
    tasks.named("build") {
        dependsOn(
            tasks.matching {
                name.endsWith("MainClasses") ||
                    name.endsWith("TestClasses") ||
                    name.endsWith("Binaries") ||
                    name.endsWith("XCFramework")
            },
        )
    }
}

// patchWasmWasiNodePreopens is omitted — no `wasmWasi {}` target is
// declared (see kotlin{} block for the CoreFoundation Apple-only
// impossibility), so `wasmWasiNodeTest` does not exist to depend on.
