// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SwiftTestHarness",
    dependencies: [
        .package(name: "CoreFoundationSys", path: "../build/SPMPackage/macosArm64/Debug")
    ],
    targets: [
        .testTarget(
            name: "SwiftTestHarnessTests",
            dependencies: [
                .product(name: "CoreFoundationSysLibrary", package: "CoreFoundationSys")
            ],
            linkerSettings: [
                .unsafeFlags([
                    "-L", "../build/swift-test",
                    "-lCoreFoundationSys",
                ]),
            ]
        ),
    ]
)
