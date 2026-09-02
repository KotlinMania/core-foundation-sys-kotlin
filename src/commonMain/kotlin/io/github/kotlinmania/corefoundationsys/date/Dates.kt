// port-lint: source date.rs
package io.github.kotlinmania.corefoundationsys.date

import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFDate
public typealias CFDateRef = __CFDate

/**
 * `CFTimeInterval` from CoreFoundation's `date.rs` (upstream `pub type CFTimeInterval = f64`).
 * Type representing a time interval in seconds.
 */
public typealias CFTimeInterval = Double

/**
 * `CFAbsoluteTime` from CoreFoundation's `date.rs` (upstream `pub type CFAbsoluteTime = CFTimeInterval`).
 * Type representing absolute time in seconds since 2001-01-01 00:00:00 UTC (Core Foundation epoch).
 */
public typealias CFAbsoluteTime = CFTimeInterval

/**
 * Time interval between the 1904 Mac epoch and the 2001 Core Foundation epoch: -3061152000.0 seconds.
 */
public const val kCFAbsoluteTimeIntervalSince1904: CFTimeInterval = -3061152000.0

/**
 * Time interval between the 1970 Unix epoch and the 2001 Core Foundation epoch: 978307200.0 seconds.
 */
public const val kCFAbsoluteTimeIntervalSince1970: CFTimeInterval = 978307200.0

public object CFDate {
    public const val TYPE_ID: CFTypeID = 29L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
