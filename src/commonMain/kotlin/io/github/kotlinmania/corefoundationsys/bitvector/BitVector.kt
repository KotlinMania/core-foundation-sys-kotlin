// port-lint: source bit_vector.rs
package io.github.kotlinmania.corefoundationsys.bitvector

import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.CFUInt32

public class __CFBitVector
public typealias CFBitVectorRef = __CFBitVector
public typealias CFMutableBitVectorRef = __CFBitVector

/**
 * `CFBit` from CoreFoundation's `bit_vector.rs` (upstream `pub type CFBit = UInt32`).
 * Value is 0 or 1.
 */
public typealias CFBit = CFUInt32

public const val kCFBitZero: CFBit = 0u
public const val kCFBitOne: CFBit = 1u

public object CFBitVector {
    public const val TYPE_ID: CFTypeID = 31L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
