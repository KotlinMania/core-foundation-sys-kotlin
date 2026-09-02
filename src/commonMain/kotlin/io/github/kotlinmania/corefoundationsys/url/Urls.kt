// port-lint: source url.rs
package io.github.kotlinmania.corefoundationsys.url

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFURL
public typealias CFURLRef = __CFURL

/**
 * `CFURLPathStyle` from CoreFoundation's `url.rs` (upstream `pub type CFURLPathStyle = CFIndex`).
 */
public typealias CFURLPathStyle = CFIndex

public const val kCFURLPOSIXPathStyle: CFURLPathStyle = 0
public const val kCFURLHFSPathStyle: CFURLPathStyle = 1
public const val kCFURLWindowsPathStyle: CFURLPathStyle = 2

/**
 * `CFURLBookmarkCreationOptions` from CoreFoundation's `url.rs` (upstream `pub type CFURLBookmarkCreationOptions = CFOptionFlags`).
 */
public typealias CFURLBookmarkCreationOptions = CFOptionFlags

public const val kCFURLBookmarkCreationPreferFileIDToObjectIdentifier: CFURLBookmarkCreationOptions = 1L
public const val kCFURLBookmarkCreationMinimalBookmarkMask: CFURLBookmarkCreationOptions = 512L
public const val kCFURLBookmarkCreationSuitableForBookmarkFile: CFURLBookmarkCreationOptions = 1024L
public const val kCFURLBookmarkCreationWithSecurityScope: CFURLBookmarkCreationOptions = 2048L
public const val kCFURLBookmarkCreationSecurityScopeAllowOnlyReadAccess: CFURLBookmarkCreationOptions = 4096L
public const val kCFURLBookmarkCreationWithoutImplicitSecurityScope: CFURLBookmarkCreationOptions = 1L shl 29
public const val kCFURLBookmarkCreationPreferFileIDResolutionMask: CFURLBookmarkCreationOptions = 1L shl 8

/**
 * `CFURLBookmarkResolutionOptions` from CoreFoundation's `url.rs` (upstream `pub type CFURLBookmarkResolutionOptions = CFOptionFlags`).
 */
public typealias CFURLBookmarkResolutionOptions = CFOptionFlags

public const val kCFURLBookmarkResolutionWithoutUIMask: CFURLBookmarkResolutionOptions = 1L shl 8
public const val kCFURLBookmarkResolutionWithoutMountingMask: CFURLBookmarkResolutionOptions = 1L shl 9
public const val kCFURLBookmarkResolutionWithSecurityScope: CFURLBookmarkResolutionOptions = 1L shl 10
public const val kCFBookmarkResolutionWithoutUIMask: CFURLBookmarkResolutionOptions = 1L shl 8
public const val kCFBookmarkResolutionWithoutMountingMask: CFURLBookmarkResolutionOptions = 1L shl 9

public typealias CFURLBookmarkFileCreationOptions = CFOptionFlags

public typealias CFURLComponentType = CFIndex
public const val kCFURLComponentScheme: CFIndex = 1
public const val kCFURLComponentNetLocation: CFIndex = 2
public const val kCFURLComponentPath: CFIndex = 3
public const val kCFURLComponentResourceSpecifier: CFIndex = 4
public const val kCFURLComponentUser: CFIndex = 5
public const val kCFURLComponentPassword: CFIndex = 6
public const val kCFURLComponentUserInfo: CFIndex = 7
public const val kCFURLComponentHost: CFIndex = 8
public const val kCFURLComponentPort: CFIndex = 9
public const val kCFURLComponentParameterString: CFIndex = 10
public const val kCFURLComponentQuery: CFIndex = 11
public const val kCFURLComponentFragment: CFIndex = 12

public const val kCFURLIsExcludedFromBackupKey: String = "NSURLIsExcludedFromBackupKey"

public object CFURL {
    public const val TYPE_ID: CFTypeID = 34L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
