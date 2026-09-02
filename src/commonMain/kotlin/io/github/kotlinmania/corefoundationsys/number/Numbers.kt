// port-lint: source number.rs
package io.github.kotlinmania.corefoundationsys.number

/**
 * `CFNumberType` from CoreFoundation's `number.rs` (upstream `pub type CFNumberType = u32`).
 */
public typealias CFNumberType = UInt

public const val kCFNumberSInt8Type: CFNumberType = 1u
public const val kCFNumberSInt16Type: CFNumberType = 2u
public const val kCFNumberSInt32Type: CFNumberType = 3u
public const val kCFNumberSInt64Type: CFNumberType = 4u
public const val kCFNumberFloat32Type: CFNumberType = 5u
public const val kCFNumberFloat64Type: CFNumberType = 6u
public const val kCFNumberCharType: CFNumberType = 7u
public const val kCFNumberShortType: CFNumberType = 8u
public const val kCFNumberIntType: CFNumberType = 9u
public const val kCFNumberLongType: CFNumberType = 10u
public const val kCFNumberLongLongType: CFNumberType = 11u
public const val kCFNumberFloatType: CFNumberType = 12u
public const val kCFNumberDoubleType: CFNumberType = 13u
public const val kCFNumberCFIndexType: CFNumberType = 14u
public const val kCFNumberNSIntegerType: CFNumberType = 15u
public const val kCFNumberCGFloatType: CFNumberType = 16u
public const val kCFNumberMaxType: CFNumberType = 16u
