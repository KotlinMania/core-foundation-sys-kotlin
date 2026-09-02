// port-lint: source data.rs
package io.github.kotlinmania.corefoundationsys.data

import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFData
public typealias CFDataRef = __CFData
public typealias CFMutableDataRef = __CFData

/**
 * `CFDataSearchFlags` from CoreFoundation's `data.rs` (upstream `pub type CFDataSearchFlags = CFOptionFlags`).
 */
public typealias CFDataSearchFlags = CFOptionFlags

public const val kCFDataSearchBackwards: CFDataSearchFlags = 1L
public const val kCFDataSearchAnchored: CFDataSearchFlags = 2L

public object CFData {
    public const val TYPE_ID: CFTypeID = 28L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
