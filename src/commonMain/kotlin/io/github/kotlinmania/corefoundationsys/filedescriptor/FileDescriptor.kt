// port-lint: source filedescriptor.rs
package io.github.kotlinmania.corefoundationsys.filedescriptor

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public typealias CFFileDescriptorNativeDescriptor = Int

public class __CFFileDescriptor
public typealias CFFileDescriptorRef = __CFFileDescriptor

public const val kCFFileDescriptorReadCallBack: CFOptionFlags = 1L shl 0
public const val kCFFileDescriptorWriteCallBack: CFOptionFlags = 1L shl 1

public typealias CFFileDescriptorCallBack = (f: CFFileDescriptorRef?, callBackTypes: CFOptionFlags, info: Any?) -> Unit

public data class CFFileDescriptorContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public object CFFileDescriptor {
    public const val TYPE_ID: CFTypeID = 50L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
