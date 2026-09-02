// port-lint: source set.rs
package io.github.kotlinmania.corefoundationsys.set

import io.github.kotlinmania.corefoundationsys.base.CFBoolean
import io.github.kotlinmania.corefoundationsys.base.CFHashCode
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFSet
public typealias CFSetRef = __CFSet
public typealias CFMutableSetRef = __CFSet

public typealias CFSetApplierFunction = (value: Any?, context: Any?) -> Unit
public typealias CFSetRetainCallBack = (allocator: Any?, value: Any?) -> Any?
public typealias CFSetReleaseCallBack = (allocator: Any?, value: Any?) -> Unit
public typealias CFSetCopyDescriptionCallBack = (value: Any?) -> Any?
public typealias CFSetEqualCallBack = (value1: Any?, value2: Any?) -> CFBoolean
public typealias CFSetHashCallBack = (value: Any?) -> CFHashCode

public data class CFSetCallBacks(
    public val version: CFIndex = 0,
    public val retain: CFSetRetainCallBack? = null,
    public val release: CFSetReleaseCallBack? = null,
    public val copyDescription: CFSetCopyDescriptionCallBack? = null,
    public val equal: CFSetEqualCallBack? = null,
    public val hash: CFSetHashCallBack? = null,
)

public object CFSet {
    public const val TYPE_ID: CFTypeID = 20L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
