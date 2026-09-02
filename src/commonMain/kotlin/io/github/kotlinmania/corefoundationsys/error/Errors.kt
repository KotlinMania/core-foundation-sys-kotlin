// port-lint: source error.rs
package io.github.kotlinmania.corefoundationsys.error

import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFError
public typealias CFErrorRef = __CFError
public typealias CFErrorDomain = String

public const val kCFErrorDomainPOSIX: CFErrorDomain = "NSPOSIXErrorDomain"
public const val kCFErrorDomainOSStatus: CFErrorDomain = "NSOSStatusErrorDomain"
public const val kCFErrorDomainMach: CFErrorDomain = "NSMachErrorDomain"
public const val kCFErrorDomainCocoa: CFErrorDomain = "NSCocoaErrorDomain"

/**
 * Standard CoreFoundation error domain string identifiers from `error.rs`.
 */
public object CFErrorDomains {
    public const val POSIX: String = kCFErrorDomainPOSIX
    public const val OSStatus: String = kCFErrorDomainOSStatus
    public const val Mach: String = kCFErrorDomainMach
    public const val Cocoa: String = kCFErrorDomainCocoa
}

/**
 * Keys for the user info dictionary in CoreFoundation errors from `error.rs`.
 */
public object CFErrorUserInfoKey {
    public const val LocalizedDescription: String = "NSLocalizedDescription"
    public const val LocalizedFailureReason: String = "NSLocalizedFailureReason"
    public const val LocalizedRecoverySuggestion: String = "NSLocalizedRecoverySuggestion"
    public const val Description: String = "NSDescription"
    public const val UnderlyingError: String = "NSUnderlyingError"
    public const val URL: String = "NSURL"
    public const val FilePath: String = "NSFilePath"
}

public object CFError {
    public const val TYPE_ID: CFTypeID = 27L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
