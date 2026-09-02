// port-lint: source timezone.rs
package io.github.kotlinmania.corefoundationsys.timezone

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFTimeZone
public typealias CFTimeZoneRef = __CFTimeZone
public typealias CFTimeZoneNameStyle = CFIndex

public const val kCFTimeZoneNameStyleStandard: CFTimeZoneNameStyle = 0
public const val kCFTimeZoneNameStyleShortStandard: CFTimeZoneNameStyle = 1
public const val kCFTimeZoneNameStyleDaylightSaving: CFTimeZoneNameStyle = 2
public const val kCFTimeZoneNameStyleShortDaylightSaving: CFTimeZoneNameStyle = 3
public const val kCFTimeZoneNameStyleGeneric: CFTimeZoneNameStyle = 4
public const val kCFTimeZoneNameStyleShortGeneric: CFTimeZoneNameStyle = 5

public object CFTimeZone {
    public const val TYPE_ID: CFTypeID = 38L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val SYSTEM_TIME_ZONE_DID_CHANGE_NOTIFICATION: String = "kCFTimeZoneSystemTimeZoneDidChangeNotification"
}
