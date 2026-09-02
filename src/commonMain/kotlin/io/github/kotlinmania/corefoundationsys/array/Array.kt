// port-lint: source array.rs
package io.github.kotlinmania.corefoundationsys.array

import io.github.kotlinmania.corefoundationsys.base.CFBoolean
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFRange
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFArray
public typealias CFArrayRef = __CFArray
public typealias CFMutableArrayRef = __CFArray

public typealias CFArrayRetainCallBack = (allocator: Any?, value: Any?) -> Any?
public typealias CFArrayReleaseCallBack = (allocator: Any?, value: Any?) -> Unit
public typealias CFArrayCopyDescriptionCallBack = (value: Any?) -> Any?
public typealias CFArrayEqualCallBack = (value1: Any?, value2: Any?) -> CFBoolean
public typealias CFArrayApplierFunction = (value: Any?, context: Any?) -> Unit

public data class CFArrayCallBacks(
    public val version: CFIndex = 0,
    public val retain: CFArrayRetainCallBack? = null,
    public val release: CFArrayReleaseCallBack? = null,
    public val copyDescription: CFArrayCopyDescriptionCallBack? = null,
    public val equal: CFArrayEqualCallBack? = null,
)

public object CFArray {
    public const val TYPE_ID: CFTypeID = 18L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
