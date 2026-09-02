// port-lint: source tree.rs
package io.github.kotlinmania.corefoundationsys.tree

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFTree
public typealias CFTreeRef = __CFTree

public typealias CFTreeRetainCallBack = (info: Any?) -> Any?
public typealias CFTreeReleaseCallBack = (info: Any?) -> Unit
public typealias CFTreeCopyDescriptionCallBack = (info: Any?) -> String?
public typealias CFTreeApplierFunction = (value: Any?, context: Any?) -> Unit

public data class CFTreeContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: CFTreeRetainCallBack? = null,
    public val release: CFTreeReleaseCallBack? = null,
    public val copyDescription: CFTreeCopyDescriptionCallBack? = null,
)

public object CFTree {
    public const val TYPE_ID: CFTypeID = 47L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
