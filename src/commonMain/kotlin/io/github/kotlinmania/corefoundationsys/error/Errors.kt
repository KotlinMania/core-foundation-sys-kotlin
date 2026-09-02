// port-lint: source error.rs
package io.github.kotlinmania.corefoundationsys.error

/**
 * Standard CoreFoundation error domain string identifiers from `error.rs`.
 */
public object CFErrorDomain {
    public const val POSIX: String = "NSPOSIXErrorDomain"
    public const val OSStatus: String = "NSOSStatusErrorDomain"
    public const val Mach: String = "NSMachErrorDomain"
    public const val Cocoa: String = "NSCocoaErrorDomain"
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
