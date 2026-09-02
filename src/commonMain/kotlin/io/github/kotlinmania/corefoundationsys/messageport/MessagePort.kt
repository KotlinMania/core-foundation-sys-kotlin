// port-lint: source messageport.rs
package io.github.kotlinmania.corefoundationsys.messageport

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.SInt32
import io.github.kotlinmania.corefoundationsys.data.CFDataRef

public class __CFMessagePort
public typealias CFMessagePortRef = __CFMessagePort

public data class CFMessagePortContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public typealias CFMessagePortCallBack = (local: CFMessagePortRef?, msgid: Int, data: CFDataRef?, info: Any?) -> CFDataRef?
public typealias CFMessagePortInvalidationCallBack = (ms: CFMessagePortRef?, info: Any?) -> Unit

public const val kCFMessagePortSuccess: SInt32 = 0
public const val kCFMessagePortSendTimeout: SInt32 = -1
public const val kCFMessagePortReceiveTimeout: SInt32 = -2
public const val kCFMessagePortIsInvalid: SInt32 = -3
public const val kCFMessagePortTransportError: SInt32 = -4
public const val kCFMessagePortBecameInvalidError: SInt32 = -5

public object CFMessagePort {
    public const val TYPE_ID: CFTypeID = 51L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
