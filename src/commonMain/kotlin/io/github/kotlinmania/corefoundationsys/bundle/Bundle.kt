// port-lint: source bundle.rs
package io.github.kotlinmania.corefoundationsys.bundle

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.base.CFUInt32
import io.github.kotlinmania.corefoundationsys.string.CFStringRef

public class __CFBundle
public typealias CFBundleRef = __CFBundle
public typealias CFPlugInRef = __CFBundle
public typealias CFBundleRefNum = Int

public const val kCFBundleExecutableArchitectureI386: CFUInt32 = 0x00000007u
public const val kCFBundleExecutableArchitecturePPC: CFUInt32 = 0x00000012u
public const val kCFBundleExecutableArchitectureX86_64: CFUInt32 = 0x01000007u
public const val kCFBundleExecutableArchitecturePPC64: CFUInt32 = 0x01000012u

public fun CFCopyLocalizedString(key: CFStringRef?, comment: CFStringRef?): CFStringRef? = key
public fun CFCopyLocalizedStringFromTable(key: CFStringRef?, tbl: CFStringRef?, comment: CFStringRef?): CFStringRef? = key
public fun CFCopyLocalizedStringFromTableInBundle(key: CFStringRef?, tbl: CFStringRef?, bundle: CFBundleRef?, comment: CFStringRef?): CFStringRef? = key
public fun CFCopyLocalizedStringWithDefaultValue(key: CFStringRef?, tbl: CFStringRef?, bundle: CFBundleRef?, value: CFStringRef?, comment: CFStringRef?): CFStringRef? = value ?: key

public object CFBundle {
    public const val TYPE_ID: CFTypeID = 23L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val INFO_DICTIONARY_VERSION_KEY: String = "CFBundleInfoDictionaryVersion"
    public const val EXECUTABLE_KEY: String = "CFBundleExecutable"
    public const val IDENTIFIER_KEY: String = "CFBundleIdentifier"
    public const val VERSION_KEY: String = "CFBundleVersion"
    public const val DEVELOPMENT_REGION_KEY: String = "CFBundleDevelopmentRegion"
    public const val NAME_KEY: String = "CFBundleName"
    public const val LOCALIZATIONS_KEY: String = "CFBundleLocalizations"
}
