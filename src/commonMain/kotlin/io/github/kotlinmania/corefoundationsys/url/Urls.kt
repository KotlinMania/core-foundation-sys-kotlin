// port-lint: source url.rs
package io.github.kotlinmania.corefoundationsys.url

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags

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

/**
 * `CFURLBookmarkResolutionOptions` from CoreFoundation's `url.rs` (upstream `pub type CFURLBookmarkResolutionOptions = CFOptionFlags`).
 */
public typealias CFURLBookmarkResolutionOptions = CFOptionFlags

public const val kCFBookmarkResolutionWithoutUIMask: CFURLBookmarkResolutionOptions = 256L
public const val kCFBookmarkResolutionWithoutMountingMask: CFURLBookmarkResolutionOptions = 512L
public const val kCFURLBookmarkResolutionWithSecurityScope: CFURLBookmarkResolutionOptions = 1024L
public const val kCFURLBookmarkResolutionWithoutImplicitStartAccessing: CFURLBookmarkResolutionOptions = 32768L
