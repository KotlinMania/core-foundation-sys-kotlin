// port-lint: source base.rs
package io.github.kotlinmania.corefoundationsys.base

/**
 * `Boolean` from CoreFoundation's `base.rs` (upstream `pub type Boolean = u8`).
 *
 * Apple's CoreFoundation defines `Boolean` as a one-byte unsigned value
 * where 0 means false and any non-zero value means true. Kotlin uses
 * [UByte] to preserve the byte width when bridging to and from
 * CoreFoundation calls in [io.github.kotlinmania.corefoundationsys.Lib].
 */
public typealias CFBoolean = UByte

/** `UInt8` from CoreFoundation's `base.rs` (upstream `pub type UInt8 = c_uchar`). */
public typealias CFUInt8 = UByte

/** `UInt16` from CoreFoundation's `base.rs` (upstream `pub type UInt16 = c_ushort`). */
public typealias CFUInt16 = UShort

/** `SInt16` from CoreFoundation's `base.rs` (upstream `pub type SInt16 = c_short`). */
public typealias CFSInt16 = Short

/** `SInt32` from CoreFoundation's `base.rs` (upstream `pub type SInt32 = c_int`). */
public typealias CFSInt32 = Int

/** `UInt32` from CoreFoundation's `base.rs` (upstream `pub type UInt32 = c_uint`). */
public typealias CFUInt32 = UInt

/**
 * `CFTypeID` from CoreFoundation's `base.rs` (upstream `pub type CFTypeID = usize`).
 *
 * `usize` in upstream Rust narrows to `Long` on the 64-bit Apple targets
 * (iOS, macOS, tvOS, watchosSimulatorArm64) and to `Int` on the ARM64_32
 * watchOS device targets (`watchosArm64`, `watchosDeviceArm64`). Exposed
 * as Kotlin [Long] here for the common-source surface; per-target FFI
 * call sites in `appleMain` narrow back via [kotlinx.cinterop.convert].
 */
public typealias CFTypeID = Long

/** `CFOptionFlags` from CoreFoundation's `base.rs` (upstream `pub type CFOptionFlags = usize`). */
public typealias CFOptionFlags = Long

/** `CFHashCode` from CoreFoundation's `base.rs` (upstream `pub type CFHashCode = usize`). */
public typealias CFHashCode = Long

/**
 * `CFIndex` from CoreFoundation's `base.rs` (upstream `pub type CFIndex = isize`).
 *
 * Indices into CoreFoundation collections. See [CFTypeID] for the same
 * 64-bit / ARM64_32 caveat — exposed as Kotlin [Int] in the
 * common-source surface to keep `CFRange` ergonomic for the dominant
 * timezone-string use case (IANA names never exceed 64 chars). Per-target
 * FFI call sites in `appleMain` widen to platform `CFIndex` via
 * [kotlinx.cinterop.convert].
 */
public typealias CFIndex = Int

/**
 * `CFRange` from CoreFoundation's `base.rs` — a half-open interval
 * `[location, location + length)` into a CFString, CFArray, CFData, or
 * any other CoreFoundation collection.
 *
 * Upstream Rust:
 * ```rust
 * pub struct CFRange {
 *     pub location: CFIndex,
 *     pub length: CFIndex,
 * }
 * ```
 */
public data class CFRange(public val location: CFIndex, public val length: CFIndex) {
    public companion object {
        /** Mirror of upstream `CFRange::init(location, length)`. */
        public fun init(location: CFIndex, length: CFIndex): CFRange = CFRange(location, length)
    }
}
