// port-lint: source notification_center.rs
package io.github.kotlinmania.corefoundationsys.notificationcenter

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFNotificationCenter
public typealias CFNotificationCenterRef = __CFNotificationCenter

public typealias CFNotificationName = String
public typealias CFNotificationCallback = (center: CFNotificationCenterRef?, observer: Any?, name: CFNotificationName?, `object`: Any?, userInfo: Any?) -> Unit
public typealias CFNotificationSuspensionBehavior = CFIndex

public const val CFNotificationSuspensionBehaviorDrop: CFNotificationSuspensionBehavior = 1
public const val CFNotificationSuspensionBehaviorCoalesce: CFNotificationSuspensionBehavior = 2
public const val CFNotificationSuspensionBehaviorHold: CFNotificationSuspensionBehavior = 3
public const val CFNotificationSuspensionBehaviorDeliverImmediately: CFNotificationSuspensionBehavior = 4

public const val kCFNotificationDeliverImmediately: CFOptionFlags = 1L shl 0
public const val kCFNotificationPostToAllSessions: CFOptionFlags = 1L shl 1

public object CFNotificationCenter {
    public const val TYPE_ID: CFTypeID = 36L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
