// port-lint: source lib.rs
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class, kotlinx.cinterop.BetaInteropApi::class)

package io.github.kotlinmania.corefoundationsys

import io.github.kotlinmania.corefoundationsys.base.CFRange
import io.github.kotlinmania.corefoundationsys.string.CFStringEncoding
import kotlinx.cinterop.toKString
import platform.CoreFoundation.CFRelease
import platform.CoreFoundation.CFStringGetCStringPtr as cf_CFStringGetCStringPtr
import platform.CoreFoundation.CFTimeZoneCopySystem as cf_CFTimeZoneCopySystem
import platform.CoreFoundation.CFTimeZoneGetName as cf_CFTimeZoneGetName
import platform.CoreFoundation.CFTimeZoneResetSystem as cf_CFTimeZoneResetSystem

/**
 * Kotlin Multiplatform port of the `core-foundation-sys` crate — the
 * Rust-side raw FFI bindings to Apple's CoreFoundation framework,
 * exposed here as a Kotlin-friendly facade.
 *
 * Upstream is `extern "C"` declarations for every CoreFoundation symbol
 * the downstream Rust ecosystem touches. Kotlin/Native already ships
 * `platform.CoreFoundation.*` for every Apple target, generated from
 * the system SDK headers. This module exposes a Kotlin-named subset of
 * that surface shaped to match the call sites in downstream `*-kotlin`
 * consumers (the first such consumer is `iana-time-zone-kotlin`'s
 * `appleMain.TzDarwin`, which is the only reason these particular
 * symbols are exposed first).
 *
 * Non-Apple targets get an empty `commonMain` — there is no
 * CoreFoundation framework off-Apple. The artifact still publishes for
 * those targets so that downstream consumers can declare a single
 * `commonMain` dep without splitting it into Apple/non-Apple variants.
 */

/** Opaque wrapper around an Apple `CFTimeZoneRef`. */
public class CFTimeZoneRef internal constructor(internal val ref: platform.CoreFoundation.CFTimeZoneRef)

/** Opaque wrapper around an Apple `CFStringRef`. */
public class CFStringRef internal constructor(internal val ref: platform.CoreFoundation.CFStringRef)

// CFRange lives in commonMain (see base/Base.kt) — `import
// io.github.kotlinmania.corefoundationsys.base.CFRange`. UTF-8 encoding
// constant lives in commonMain too: `kCFStringEncodingUTF8` in
// string/Strings.kt mirrors the upstream Rust name verbatim.

/**
 * Release a CoreFoundation object, matching `CFRelease(CFTypeRef)`.
 *
 * The upstream Rust port wraps every Create-rule pointer in a `Drop`
 * impl that issues `CFRelease`; Kotlin/Native does not have `Drop`, so
 * consumers call this explicitly in their own `release()` / cleanup
 * methods.
 */
public fun cfRelease(ref: CFTimeZoneRef): Unit = CFRelease(ref.ref)

/**
 * Invalidate any cached system timezone, matching `CFTimeZoneResetSystem()`.
 *
 * Calling this before [cfTimeZoneCopySystem] is the only way to observe
 * a timezone change made after the process started — see the upstream
 * `tz_darwin.rs` comment block for context.
 */
public fun cfTimeZoneResetSystem(): Unit = cf_CFTimeZoneResetSystem()

/**
 * Get the current system timezone, matching `CFTimeZoneCopySystem()`.
 *
 * Returns null on failure (NULL pointer). The caller owns the returned
 * reference and is responsible for [cfRelease].
 */
public fun cfTimeZoneCopySystem(): CFTimeZoneRef? {
    val ref = cf_CFTimeZoneCopySystem() ?: return null
    return CFTimeZoneRef(ref)
}

/**
 * Get the IANA name of a timezone, matching `CFTimeZoneGetName(CFTimeZoneRef)`.
 *
 * The returned [CFStringRef] is borrowed from the parent [CFTimeZoneRef]
 * (a Get-rule reference in CoreFoundation terms) and must NOT be
 * released independently.
 */
public fun cfTimeZoneGetName(tz: CFTimeZoneRef): CFStringRef? {
    val string = cf_CFTimeZoneGetName(tz.ref) ?: return null
    return CFStringRef(string)
}

/**
 * Try to get a pointer to the C-string representation of a CFString
 * in the requested encoding without copying, matching
 * `CFStringGetCStringPtr(CFStringRef, encoding)`.
 *
 * Returns null if the CFString's internal representation is
 * incompatible with the requested encoding (the most common case —
 * CFString often holds UTF-16 internally).
 */
public fun cfStringGetCStringPtr(string: CFStringRef, encoding: UInt): String? {
    val ptr = cf_CFStringGetCStringPtr(string.ref, encoding) ?: return null
    return ptr.toKString()
}

/**
 * Length of a CFString in UTF-16 code units, matching
 * `CFStringGetLength(CFStringRef)`.
 *
 * Returned as Kotlin `Int` even though CoreFoundation's `CFIndex` is
 * `Long` on 64-bit Apple targets (iOS, macOS, tvOS, watchosSimulatorArm64)
 * and `Int` on the ARM64_32 watchOS device targets (`watchosArm64`,
 * `watchosDeviceArm64`). Because the underlying `CFIndex` pointer type
 * differs by target, the implementation is pushed to per-leaf-target
 * actual source sets (see workspace AGENTS.md memory
 * `feedback_posixmain_avoid_size_t` — same pattern as `size_t` in
 * posixMain).
 */
public expect fun cfStringGetLength(string: CFStringRef): Int

/**
 * Copy bytes of a CFString into [buf], matching
 * `CFStringGetBytes(CFStringRef, CFRange, encoding, lossByte,
 * isExternalRepresentation, *buffer, maxBufLen, *usedBufLen)`.
 *
 * Returns the number of UTF-16 code units that were converted. Callers
 * compare this against `range.length` to detect partial conversions
 * (a returned value less than `range.length` means the buffer was too
 * small or the encoding could not represent some character).
 *
 * Note: this signature folds away CoreFoundation's separate
 * `usedBufLen` out-parameter; callers that need the exact byte count
 * written can re-read the encoded length via [cfStringGetLength] +
 * encoding-aware sizing. The first consumer
 * (`iana-time-zone-kotlin`'s `TzDarwin.kt`) uses ASCII-only timezone
 * names where chars == bytes, so this simpler signature is sufficient.
 */
public expect fun cfStringGetBytes(
    string: CFStringRef,
    range: CFRange,
    encoding: UInt,
    lossByte: UByte,
    isExternalRepresentation: Boolean,
    buf: ByteArray,
    maxBufLen: Int,
): Int
