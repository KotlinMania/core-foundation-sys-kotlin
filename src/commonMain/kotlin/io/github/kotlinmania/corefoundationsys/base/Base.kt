// port-lint: source base.rs
package io.github.kotlinmania.corefoundationsys.base

/**
 * `Boolean` from CoreFoundation's `base.rs` (upstream `pub type Boolean = u8`).
 *
 * Apple's CoreFoundation defines `Boolean` as a one-byte unsigned value
 * where 0 means false and any non-zero value means true.
 */
public typealias Boolean = UByte
public typealias CFBoolean = UByte

/** `UInt8` from CoreFoundation's `base.rs` (upstream `pub type UInt8 = c_uchar`). */
public typealias UInt8 = UByte
public typealias CFUInt8 = UByte

/** `UInt16` from CoreFoundation's `base.rs` (upstream `pub type UInt16 = c_ushort`). */
public typealias UInt16 = UShort
public typealias CFUInt16 = UShort

/** `SInt16` from CoreFoundation's `base.rs` (upstream `pub type SInt16 = c_short`). */
public typealias SInt16 = Short
public typealias CFSInt16 = Short

/** `SInt32` from CoreFoundation's `base.rs` (upstream `pub type SInt32 = c_int`). */
public typealias SInt32 = Int
public typealias CFSInt32 = Int

/** `UInt32` from CoreFoundation's `base.rs` (upstream `pub type UInt32 = c_uint`). */
public typealias UInt32 = UInt
public typealias CFUInt32 = UInt

/**
 * `CFTypeID` from CoreFoundation's `base.rs` (upstream `pub type CFTypeID = usize`).
 */
public typealias CFTypeID = Long

/** `CFOptionFlags` from CoreFoundation's `base.rs` (upstream `pub type CFOptionFlags = usize`). */
public typealias CFOptionFlags = Long

/** `CFHashCode` from CoreFoundation's `base.rs` (upstream `pub type CFHashCode = usize`). */
public typealias CFHashCode = Long

/**
 * `CFIndex` from CoreFoundation's `base.rs` (upstream `pub type CFIndex = isize`).
 */
public typealias CFIndex = Int

/** `Boolean` typealias matching upstream `pub type Boolean = u8`. */
public typealias BooleanType = CFBoolean

/** `mach_port_t` matching upstream `pub type mach_port_t = c_uint`. */
public typealias mach_port_t = CFUInt32

/** `OSStatus` matching upstream `pub type OSStatus = i32`. */
public typealias OSStatus = Int

/** `LangCode` matching upstream `pub type LangCode = SInt16`. */
public typealias LangCode = CFSInt16

/** `RegionCode` matching upstream `pub type RegionCode = SInt16`. */
public typealias RegionCode = CFSInt16

/** `UTF32Char` matching upstream `pub type UTF32Char = c_uint`. */
public typealias UTF32Char = CFUInt32

/** `UTF16Char` matching upstream `pub type UTF16Char = c_ushort`. */
public typealias UTF16Char = CFUInt16

/** `UTF8Char` matching upstream `pub type UTF8Char = c_uchar`. */
public typealias UTF8Char = CFUInt8

public typealias CFAllocatorRef = Any?
public typealias CFNullRef = Any?
public typealias CFTypeRef = Any?
public typealias ConstStr255Param = ByteArray?
public typealias StringPtr = ByteArray?
public typealias ConstStringPtr = ByteArray?

/**
 * `CFComparisonResult` from CoreFoundation's `base.rs`.
 */
public enum class CFComparisonResult(public val value: CFIndex) {
    LessThan(-1),
    EqualTo(0),
    GreaterThan(1);

    public companion object {
        public fun from(value: CFIndex): CFComparisonResult = when (value) {
            -1 -> LessThan
            0 -> EqualTo
            1 -> GreaterThan
            else -> throw IllegalArgumentException("Unknown CFComparisonResult value: $value")
        }

        public fun fromValue(value: CFIndex): CFComparisonResult = from(value)
    }
}

public typealias CFComparatorFunction = (val1: Any?, val2: Any?, context: Any?) -> CFComparisonResult

/** Constant used to indicate failed searches (upstream `pub static kCFNotFound: CFIndex = -1`). */
public const val kCFNotFound: CFIndex = -1

/**
 * `CFRange` from CoreFoundation's `base.rs` — a half-open interval
 * `[location, location + length)` into a CFString, CFArray, CFData, or
 * any other CoreFoundation collection.
 */
public data class CFRange(
    public val location: CFIndex,
    public val length: CFIndex,
) {
    public companion object {
        /** Mirror of upstream `CFRange::init(location, length)`. */
        public fun init(location: CFIndex, length: CFIndex): CFRange = CFRange(location, length)
    }
}

public typealias CFAllocatorRetainCallBack = (info: Any?) -> Any?
public typealias CFAllocatorReleaseCallBack = (info: Any?) -> Unit
public typealias CFAllocatorCopyDescriptionCallBack = (info: Any?) -> Any?
public typealias CFAllocatorAllocateCallBack = (allocSize: CFIndex, hint: CFOptionFlags, info: Any?) -> Any?
public typealias CFAllocatorReallocateCallBack = (ptr: Any?, newsize: CFIndex, hint: CFOptionFlags, info: Any?) -> Any?
public typealias CFAllocatorDeallocateCallBack = (ptr: Any?, info: Any?) -> Unit
public typealias CFAllocatorPreferredSizeCallBack = (size: CFIndex, hint: CFOptionFlags, info: Any?) -> CFIndex

public data class CFAllocatorContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: CFAllocatorRetainCallBack? = null,
    public val release: CFAllocatorReleaseCallBack? = null,
    public val copyDescription: CFAllocatorCopyDescriptionCallBack? = null,
    public val allocate: CFAllocatorAllocateCallBack? = null,
    public val reallocate: CFAllocatorReallocateCallBack? = null,
    public val deallocate: CFAllocatorDeallocateCallBack? = null,
    public val preferredSize: CFAllocatorPreferredSizeCallBack? = null,
)

/**
 * Trait for all types which are Core Foundation reference types.
 */
public interface TCFTypeRef {
    public fun asVoidPtr(): Any?

    public companion object {
        public fun fromVoidPtr(ptr: Any?): Any? = ptr
    }
}
