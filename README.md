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

Non-Apple targets get an empty `commonMain`. The artifact still publishes
for every standard Kotlin Multiplatform target so consumers can declare
a single `commonMain` dependency without splitting it into Apple /
non-Apple variants.

## Install

```kotlin
appleMain.dependencies {
    implementation("io.github.kotlinmania:core-foundation-sys-kotlin:0.1.0")
}
```

## Upstream

- Crate: [`core-foundation-sys`](https://crates.io/crates/core-foundation-sys) 0.8.6
- Source: [`servo/core-foundation-rs`](https://github.com/servo/core-foundation-rs/tree/main/core-foundation-sys)
- License: MIT OR Apache-2.0

## License

Dual-licensed under the MIT license and the Apache License, Version 2.0,
matching the upstream crate.
