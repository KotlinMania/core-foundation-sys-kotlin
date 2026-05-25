// port-lint: source lib.rs
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class, kotlinx.cinterop.BetaInteropApi::class)

package io.github.kotlinmania.corefoundationsys

import io.github.kotlinmania.corefoundationsys.base.CFRange
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pin
import kotlinx.cinterop.reinterpret
import platform.CoreFoundation.CFRangeMake
import platform.CoreFoundation.CFStringGetBytes as cf_CFStringGetBytes
import platform.CoreFoundation.CFStringGetLength as cf_CFStringGetLength

// CoreFoundation's CFIndex pointer type differs between 64-bit Apple
// (Long*) and ARM64_32 watchOS (Int*). Pushed to per-leaf-target actuals
// so each compile sees a single concrete CFIndex width — see workspace
// AGENTS.md memory `feedback_posixmain_avoid_size_t` for the analogous
// posixMain / size_t pattern.

public actual fun cfStringGetLength(string: CFStringRef): Int =
    cf_CFStringGetLength(string.ref).convert()

public actual fun cfStringGetBytes(
    string: CFStringRef,
    range: CFRange,
    encoding: UInt,
    lossByte: UByte,
    isExternalRepresentation: Boolean,
    buf: ByteArray,
    maxBufLen: Int,
): Int = memScoped {
    val cfRange = CFRangeMake(range.location.convert(), range.length.convert())
    val pinned = buf.pin()
    try {
        cf_CFStringGetBytes(
            string.ref,
            cfRange,
            encoding,
            lossByte,
            isExternalRepresentation,
            pinned.addressOf(0).reinterpret(),
            maxBufLen.convert(),
            // NULL usedBufLen out-param — the first consumer doesn't use
            // it and skipping it dodges the CFIndex-pointer bit-width
            // gap between targets.
            null,
        ).convert()
    } finally {
        pinned.unpin()
    }
}
