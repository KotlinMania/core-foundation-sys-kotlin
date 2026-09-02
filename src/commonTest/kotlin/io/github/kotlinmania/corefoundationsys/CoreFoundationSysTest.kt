// port-lint: tests tests/lib.rs
package io.github.kotlinmania.corefoundationsys

import io.github.kotlinmania.corefoundationsys.base.CFRange
import io.github.kotlinmania.corefoundationsys.bitvector.kCFBitOne
import io.github.kotlinmania.corefoundationsys.bitvector.kCFBitZero
import io.github.kotlinmania.corefoundationsys.data.kCFDataSearchAnchored
import io.github.kotlinmania.corefoundationsys.data.kCFDataSearchBackwards
import io.github.kotlinmania.corefoundationsys.date.kCFAbsoluteTimeIntervalSince1904
import io.github.kotlinmania.corefoundationsys.date.kCFAbsoluteTimeIntervalSince1970
import io.github.kotlinmania.corefoundationsys.error.CFErrorDomain
import io.github.kotlinmania.corefoundationsys.error.CFErrorUserInfoKey
import io.github.kotlinmania.corefoundationsys.number.kCFNumberFloat32Type
import io.github.kotlinmania.corefoundationsys.number.kCFNumberFloat64Type
import io.github.kotlinmania.corefoundationsys.number.kCFNumberMaxType
import io.github.kotlinmania.corefoundationsys.number.kCFNumberSInt32Type
import io.github.kotlinmania.corefoundationsys.propertylist.kCFPropertyListBinaryFormat_v1_0
import io.github.kotlinmania.corefoundationsys.propertylist.kCFPropertyListImmutable
import io.github.kotlinmania.corefoundationsys.propertylist.kCFPropertyListMutableContainers
import io.github.kotlinmania.corefoundationsys.propertylist.kCFPropertyListXMLFormat_v1_0
import io.github.kotlinmania.corefoundationsys.string.kCFStringEncodingMacRoman
import io.github.kotlinmania.corefoundationsys.string.kCFStringEncodingUTF8
import io.github.kotlinmania.corefoundationsys.url.kCFBookmarkResolutionWithoutUIMask
import io.github.kotlinmania.corefoundationsys.url.kCFURLBookmarkCreationMinimalBookmarkMask
import io.github.kotlinmania.corefoundationsys.url.kCFURLPOSIXPathStyle
import io.github.kotlinmania.corefoundationsys.uuid.CFUUIDBytes
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CoreFoundationSysTest {

    @Test
    fun testCFRange() {
        val range = CFRange.init(10, 20)
        assertEquals(10, range.location)
        assertEquals(20, range.length)
        assertEquals(CFRange(10, 20), range)
        assertEquals(-1, io.github.kotlinmania.corefoundationsys.base.kCFNotFound)
        assertEquals(io.github.kotlinmania.corefoundationsys.base.CFComparisonResult.EqualTo, io.github.kotlinmania.corefoundationsys.base.CFComparisonResult.fromValue(0))
    }

    @Test
    fun testStringEncodingConstants() {
        assertEquals(0u, kCFStringEncodingMacRoman)
        assertEquals(0x08000100u, kCFStringEncodingUTF8)
    }

    @Test
    fun testUUIDBytesConversion() {
        val raw = byteArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val uuid = CFUUIDBytes.fromByteArray(raw)
        assertEquals(0u.toUByte(), uuid.byte0)
        assertEquals(15u.toUByte(), uuid.byte15)
        val roundtrip = uuid.toByteArray()
        assertTrue(raw.contentEquals(roundtrip))
    }

    @Test
    fun testNumberTypes() {
        assertEquals(3u, kCFNumberSInt32Type)
        assertEquals(5u, kCFNumberFloat32Type)
        assertEquals(6u, kCFNumberFloat64Type)
        assertEquals(16u, kCFNumberMaxType)
    }

    @Test
    fun testDataSearchFlags() {
        assertEquals(1L, kCFDataSearchBackwards)
        assertEquals(2L, kCFDataSearchAnchored)
    }

    @Test
    fun testErrorConstants() {
        assertEquals("NSPOSIXErrorDomain", CFErrorDomain.POSIX)
        assertEquals("NSCocoaErrorDomain", CFErrorDomain.Cocoa)
        assertEquals("NSLocalizedDescription", CFErrorUserInfoKey.LocalizedDescription)
        assertEquals("NSUnderlyingError", CFErrorUserInfoKey.UnderlyingError)
    }

    @Test
    fun testDateEpochs() {
        assertEquals(-3061152000.0, kCFAbsoluteTimeIntervalSince1904)
        assertEquals(978307200.0, kCFAbsoluteTimeIntervalSince1970)
    }

    @Test
    fun testBitVector() {
        assertEquals(0u, kCFBitZero)
        assertEquals(1u, kCFBitOne)
    }

    @Test
    fun testPropertyList() {
        assertEquals(100, kCFPropertyListXMLFormat_v1_0)
        assertEquals(200, kCFPropertyListBinaryFormat_v1_0)
        assertEquals(0L, kCFPropertyListImmutable)
        assertEquals(1L, kCFPropertyListMutableContainers)
    }

    @Test
    fun testUrlConstants() {
        assertEquals(0, kCFURLPOSIXPathStyle)
        assertEquals(512L, kCFURLBookmarkCreationMinimalBookmarkMask)
        assertEquals(256L, kCFBookmarkResolutionWithoutUIMask)
    }
}
