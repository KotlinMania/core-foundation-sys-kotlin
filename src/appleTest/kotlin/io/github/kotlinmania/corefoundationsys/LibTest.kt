// port-lint: tests lib.rs
package io.github.kotlinmania.corefoundationsys

import io.github.kotlinmania.corefoundationsys.base.CFRange
import io.github.kotlinmania.corefoundationsys.string.kCFStringEncodingUTF8
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class LibTest {
    /**
     * Smoke-test the round-trip from `CFTimeZoneCopySystem` →
     * `CFTimeZoneGetName` → `CFStringGetCStringPtr`. Every Apple host
     * has a system timezone configured, and IANA timezone names are
     * ASCII-only, so the C-string path should succeed without falling
     * back to [cfStringGetBytes].
     */
    @Test
    fun systemTimeZoneNameRoundTrip() {
        cfTimeZoneResetSystem()
        val tz = cfTimeZoneCopySystem()
        assertNotNull(tz)
        try {
            val name = cfTimeZoneGetName(tz)
            assertNotNull(name)

            val asString = cfStringGetCStringPtr(name, kCFStringEncodingUTF8)
            assertNotNull(asString)
            assertFalse(asString.isEmpty())

            val length = cfStringGetLength(name)
            assertTrue(length > 0)
            assertTrue(length <= 64, "IANA names should not exceed 64 chars, got $length")
        } finally {
            cfRelease(tz)
        }
    }

    /**
     * [cfStringGetBytes] should be able to round-trip an IANA name into
     * a UTF-8 byte buffer with chars-converted == length.
     */
    @Test
    fun stringGetBytesCopiesAsciiName() {
        cfTimeZoneResetSystem()
        val tz = cfTimeZoneCopySystem()
        assertNotNull(tz)
        try {
            val name = cfTimeZoneGetName(tz)
            assertNotNull(name)

            val length = cfStringGetLength(name)
            val buf = ByteArray(64)
            val converted =
                cfStringGetBytes(
                    string = name,
                    range = CFRange(0, length),
                    encoding = kCFStringEncodingUTF8,
                    lossByte = 0u,
                    isExternalRepresentation = false,
                    buf = buf,
                    maxBufLen = buf.size,
                )
            assertTrue(converted == length, "expected $length chars converted, got $converted")
        } finally {
            cfRelease(tz)
        }
    }
}
