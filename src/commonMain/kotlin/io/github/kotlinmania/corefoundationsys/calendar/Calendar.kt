// port-lint: source calendar.rs
package io.github.kotlinmania.corefoundationsys.calendar

import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFCalendar
public typealias CFCalendarRef = __CFCalendar

public typealias CFCalendarUnit = CFOptionFlags

public const val kCFCalendarUnitEra: CFCalendarUnit = 1L shl 1
public const val kCFCalendarUnitYear: CFCalendarUnit = 1L shl 2
public const val kCFCalendarUnitMonth: CFCalendarUnit = 1L shl 3
public const val kCFCalendarUnitDay: CFCalendarUnit = 1L shl 4
public const val kCFCalendarUnitHour: CFCalendarUnit = 1L shl 5
public const val kCFCalendarUnitMinute: CFCalendarUnit = 1L shl 6
public const val kCFCalendarUnitSecond: CFCalendarUnit = 1L shl 7
public const val kCFCalendarUnitWeek: CFCalendarUnit = 1L shl 8
public const val kCFCalendarUnitWeekday: CFCalendarUnit = 1L shl 9
public const val kCFCalendarUnitWeekdayOrdinal: CFCalendarUnit = 1L shl 10
public const val kCFCalendarUnitQuarter: CFCalendarUnit = 1L shl 11
public const val kCFCalendarUnitWeekOfMonth: CFCalendarUnit = 1L shl 12
public const val kCFCalendarUnitWeekOfYear: CFCalendarUnit = 1L shl 13
public const val kCFCalendarUnitYearForWeekOfYear: CFCalendarUnit = 1L shl 14

public const val kCFCalendarComponentsWrap: CFOptionFlags = 1L shl 0

public object CFCalendar {
    public const val TYPE_ID: CFTypeID = 24L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
