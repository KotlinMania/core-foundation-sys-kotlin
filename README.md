# core-foundation-sys-kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Fcore--foundation--sys--kotlin-blue.svg)](https://github.com/KotlinMania/core-foundation-sys-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/core-foundation-sys-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/core-foundation-sys-kotlin)

Kotlin Multiplatform port of the
[`core-foundation-sys`](https://crates.io/crates/core-foundation-sys)
Rust crate — Rust-side raw FFI bindings to Apple's CoreFoundation
framework, exposed here as a Kotlin-friendly facade.

## Scope

Upstream is `extern "C"` declarations for every CoreFoundation symbol
the downstream Rust ecosystem touches. Kotlin/Native already ships
`platform.CoreFoundation.*` for every Apple target — iOS, macOS, tvOS,
watchOS — generated from the system SDK headers, so this crate is a
thin wrapper that re-exposes a Kotlin-named subset of that surface
shaped to match the call sites in downstream `*-kotlin` consumers.

The first such consumer is
[`iana-time-zone-kotlin`](https://github.com/KotlinMania/iana-time-zone-kotlin)'s
`appleMain.TzDarwin`, which is the only reason this initial release
exposes the timezone + string surface specifically:

- `cfRelease`
- `cfTimeZoneCopySystem` / `cfTimeZoneResetSystem` / `cfTimeZoneGetName`
- `cfStringGetCStringPtr` / `cfStringGetLength` / `cfStringGetBytes`
- `CFTimeZoneRef`, `CFStringRef`, `CFRange`, `CF_STRING_ENCODING_UTF8`

Additional symbols will be added in later releases as downstream
consumers need them.

## Apple-only target surface

Per workspace AGENTS.md §5.4 "documented technical impossibility", this
repo declares **only** Apple targets in its `kotlin { … }` block:

- `macosArm64`
- `iosArm64`, `iosSimulatorArm64`, `iosX64`
- `tvosArm64`, `tvosSimulatorArm64`
- `watchosArm64`, `watchosDeviceArm64`, `watchosSimulatorArm64`

The standard KMP non-Apple targets (`jvm`, `android`, `js`, `wasmJs`,
`wasmWasi`, `linuxX64`, `linuxArm64`, `mingwX64`,
`androidNativeArm32/Arm64/X86/X64`) are intentionally absent. CoreFoundation
is a private Apple framework with no implementation off-Apple, and
Kotlin/Native's `platform.CoreFoundation.*` bindings exist only for Apple
targets — there is no kotlinmania sibling that could bridge those symbols
on a non-Apple host. The upstream Rust crate matches this scoping
(`[target.'cfg(target_vendor = "apple")'.dependencies]` in
`iana-time-zone`'s Cargo.toml).

Consumers depend on this from their own `appleMain` source set:

```kotlin
sourceSets {
    val appleMain by getting {
        dependencies {
            implementation("io.github.kotlinmania:core-foundation-sys-kotlin:0.1.1")
        }
    }
}
```

Depending on it from `commonMain` is unsupported; Gradle's KMP resolver
will fail dependency resolution for any non-Apple target the consumer
declares.

## Install

```kotlin
appleMain.dependencies {
    implementation("io.github.kotlinmania:core-foundation-sys-kotlin:0.1.1")
}
```

## Upstream

- Crate: [`core-foundation-sys`](https://crates.io/crates/core-foundation-sys) 0.8.6
- Source: [`servo/core-foundation-rs`](https://github.com/servo/core-foundation-rs/tree/main/core-foundation-sys)
- License: MIT OR Apache-2.0

## License

Dual-licensed under the MIT license and the Apache License, Version 2.0,
matching the upstream crate.
