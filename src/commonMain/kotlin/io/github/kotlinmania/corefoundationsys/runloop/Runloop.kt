// port-lint: source runloop.rs
package io.github.kotlinmania.corefoundationsys.runloop

import io.github.kotlinmania.corefoundationsys.base.CFHashCode
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFRunLoop
public typealias CFRunLoopRef = __CFRunLoop

public class __CFRunLoopSource
public typealias CFRunLoopSourceRef = __CFRunLoopSource

public class __CFRunLoopObserver
public typealias CFRunLoopObserverRef = __CFRunLoopObserver

public class __CFRunLoopTimer
public typealias CFRunLoopTimerRef = __CFRunLoopTimer

public const val kCFRunLoopRunFinished: Int = 1
public const val kCFRunLoopRunStopped: Int = 2
public const val kCFRunLoopRunTimedOut: Int = 3
public const val kCFRunLoopRunHandledSource: Int = 4

public typealias CFRunLoopActivity = CFOptionFlags
public const val kCFRunLoopEntry: CFOptionFlags = 1L shl 0
public const val kCFRunLoopBeforeTimers: CFOptionFlags = 1L shl 1
public const val kCFRunLoopBeforeSources: CFOptionFlags = 1L shl 2
public const val kCFRunLoopBeforeWaiting: CFOptionFlags = 1L shl 5
public const val kCFRunLoopAfterWaiting: CFOptionFlags = 1L shl 6
public const val kCFRunLoopExit: CFOptionFlags = 1L shl 7
public const val kCFRunLoopAllActivities: CFOptionFlags = 0x0FFFFFFFL

public data class CFRunLoopSourceContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
    public val equal: ((info1: Any?, info2: Any?) -> Boolean)? = null,
    public val hash: ((info: Any?) -> CFHashCode)? = null,
    public val schedule: ((info: Any?, rl: CFRunLoopRef?, mode: String?) -> Unit)? = null,
    public val cancel: ((info: Any?, rl: CFRunLoopRef?, mode: String?) -> Unit)? = null,
    public val perform: ((info: Any?) -> Unit)? = null,
)

public data class CFRunLoopSourceContext1(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
    public val equal: ((info1: Any?, info2: Any?) -> Boolean)? = null,
    public val hash: ((info: Any?) -> CFHashCode)? = null,
    public val getPort: ((info: Any?) -> Any?)? = null,
    public val perform: ((info: Any?) -> Any?)? = null,
)

public data class CFRunLoopObserverContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public typealias CFRunLoopObserverCallBack = (observer: CFRunLoopObserverRef?, activity: CFRunLoopActivity, info: Any?) -> Unit

public data class CFRunLoopTimerContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> String?)? = null,
)

public typealias CFRunLoopTimerCallBack = (timer: CFRunLoopTimerRef?, info: Any?) -> Unit

public const val kCFRunLoopDefaultMode: String = "kCFRunLoopDefaultMode"
public const val kCFRunLoopCommonModes: String = "kCFRunLoopCommonModes"

public object CFRunLoop {
    public const val TYPE_ID: CFTypeID = 40L

    public fun getTypeID(): CFTypeID = TYPE_ID
}

public object CFRunLoopSource {
    public const val TYPE_ID: CFTypeID = 41L

    public fun getTypeID(): CFTypeID = TYPE_ID
}

public object CFRunLoopObserver {
    public const val TYPE_ID: CFTypeID = 42L

    public fun getTypeID(): CFTypeID = TYPE_ID
}

public object CFRunLoopTimer {
    public const val TYPE_ID: CFTypeID = 43L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
