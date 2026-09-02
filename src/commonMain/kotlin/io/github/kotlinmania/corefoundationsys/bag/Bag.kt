// port-lint: source bag.rs
package io.github.kotlinmania.corefoundationsys.bag

import io.github.kotlinmania.corefoundationsys.base.CFBoolean
import io.github.kotlinmania.corefoundationsys.base.CFHashCode
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFBag
public typealias CFBagRef = __CFBag
public typealias CFMutableBagRef = __CFBag

public typealias CFBagRetainCallBack = (allocator: Any?, value: Any?) -> Any?
public typealias CFBagReleaseCallBack = (allocator: Any?, value: Any?) -> Unit
public typealias CFBagCopyDescriptionCallBack = (value: Any?) -> Any?
public typealias CFBagEqualCallBack = (value1: Any?, value2: Any?) -> CFBoolean
public typealias CFBagHashCallBack = (value: Any?) -> CFHashCode
public typealias CFBagApplierFunction = (value: Any?, context: Any?) -> Unit

public data class CFBagCallBacks(
    public val version: CFIndex = 0,
    public val retain: CFBagRetainCallBack? = null,
    public val release: CFBagReleaseCallBack? = null,
    public val copyDescription: CFBagCopyDescriptionCallBack? = null,
    public val equal: CFBagEqualCallBack? = null,
    public val hash: CFBagHashCallBack? = null,
)

public object CFBag {
    public const val TYPE_ID: CFTypeID = 21L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
