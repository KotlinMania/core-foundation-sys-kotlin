// port-lint: source plugin.rs
package io.github.kotlinmania.corefoundationsys.plugin

import io.github.kotlinmania.corefoundationsys.base.CFAllocatorRef
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.bundle.CFPlugInRef
import io.github.kotlinmania.corefoundationsys.uuid.CFUUIDRef

public class __CFPlugInInstance
public typealias CFPlugInInstanceRef = __CFPlugInInstance

public typealias CFPlugInDynamicRegisterFunction = (plugIn: CFPlugInRef?) -> Unit
public typealias CFPlugInUnloadFunction = (plugIn: CFPlugInRef?) -> Unit
public typealias CFPlugInFactoryFunction = (allocator: CFAllocatorRef, typeUUID: CFUUIDRef?) -> Any?

public typealias CFPlugInInstanceGetInterfaceFunction = (instance: CFPlugInInstanceRef?, interfaceName: String?, ftbl: Any?) -> Boolean
public typealias CFPlugInInstanceDeallocateInstanceDataFunction = (instanceData: Any?) -> Unit

public object CFPlugIn {
    public const val TYPE_ID: CFTypeID = 53L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val DYNAMIC_REGISTRATION_KEY: String = "kCFPlugInDynamicRegistrationKey"
    public const val DYNAMIC_REGISTER_FUNCTION_KEY: String = "kCFPlugInDynamicRegisterFunctionKey"
    public const val UNLOAD_FUNCTION_KEY: String = "kCFPlugInUnloadFunctionKey"
    public const val FACTORIES_KEY: String = "kCFPlugInFactoriesKey"
    public const val TYPES_KEY: String = "kCFPlugInTypesKey"
}

public object CFPlugInInstance {
    public const val TYPE_ID: CFTypeID = 54L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
