// port-lint: source file_security.rs
package io.github.kotlinmania.corefoundationsys.filesecurity

import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFFileSecurity
public typealias CFFileSecurityRef = __CFFileSecurity

public typealias CFFileSecurityClearOptions = CFOptionFlags

public const val kCFFileSecurityClearOwner: CFFileSecurityClearOptions = 1L shl 0
public const val kCFFileSecurityClearGroup: CFFileSecurityClearOptions = 1L shl 1
public const val kCFFileSecurityClearMode: CFFileSecurityClearOptions = 1L shl 2
public const val kCFFileSecurityClearOwnerUUID: CFFileSecurityClearOptions = 1L shl 3
public const val kCFFileSecurityClearGroupUUID: CFFileSecurityClearOptions = 1L shl 4
public const val kCFFileSecurityClearAccessControlList: CFFileSecurityClearOptions = 1L shl 5

public object CFFileSecurity {
    public const val TYPE_ID: CFTypeID = 49L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
