// port-lint: source mach_port.rs
package io.github.kotlinmania.corefoundationsys.machport

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.mach_port_t

public class __CFMachPort
public typealias CFMachPortRef = __CFMachPort

public typealias CFMachPortCallBack = (port: CFMachPortRef?, msg: Any?, size: CFIndex, info: Any?) -> Unit
public typealias CFMachPortInvalidationCallBack = (port: CFMachPortRef?, info: Any?) -> Unit

public data class CFMachPortContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public object CFMachPort {
    public const val TYPE_ID: CFTypeID = 39L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
