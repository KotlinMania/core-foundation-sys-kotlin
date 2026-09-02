// port-lint: source date_formatter.rs
package io.github.kotlinmania.corefoundationsys.dateformatter

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFDateFormatter
public typealias CFDateFormatterRef = __CFDateFormatter

public typealias CFDateFormatterKey = String
public typealias CFDateFormatterStyle = CFIndex
public typealias CFISO8601DateFormatOptions = CFOptionFlags

public const val kCFDateFormatterNoStyle: CFDateFormatterStyle = 0
public const val kCFDateFormatterShortStyle: CFDateFormatterStyle = 1
public const val kCFDateFormatterMediumStyle: CFDateFormatterStyle = 2
public const val kCFDateFormatterLongStyle: CFDateFormatterStyle = 3
public const val kCFDateFormatterFullStyle: CFDateFormatterStyle = 4

public object CFDateFormatter {
    public const val TYPE_ID: CFTypeID = 26L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val IS_LENIENT: CFDateFormatterKey = "kCFDateFormatterIsLenient"
    public const val TIME_ZONE: CFDateFormatterKey = "kCFDateFormatterTimeZone"
    public const val CALENDAR_NAME: CFDateFormatterKey = "kCFDateFormatterCalendarName"
    public const val DEFAULT_FORMAT: CFDateFormatterKey = "kCFDateFormatterDefaultFormat"
    public const val TWO_DIGIT_START_DATE: CFDateFormatterKey = "kCFDateFormatterTwoDigitStartDate"
    public const val DEFAULT_DATE: CFDateFormatterKey = "kCFDateFormatterDefaultDate"
    public const val CALENDAR: CFDateFormatterKey = "kCFDateFormatterCalendar"
    public const val ERA_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterEraSymbols"
    public const val MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterMonthSymbols"
    public const val SHORT_MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortMonthSymbols"
    public const val WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterWeekdaySymbols"
    public const val SHORT_WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortWeekdaySymbols"
    public const val AM_SYMBOL: CFDateFormatterKey = "kCFDateFormatterAMSymbol"
    public const val PM_SYMBOL: CFDateFormatterKey = "kCFDateFormatterPMSymbol"
    public const val LONG_ERA_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterLongEraSymbols"
    public const val VERY_SHORT_MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterVeryShortMonthSymbols"
    public const val STANDALONE_MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterStandaloneMonthSymbols"
    public const val SHORT_STANDALONE_MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortStandaloneMonthSymbols"
    public const val VERY_SHORT_STANDALONE_MONTH_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterVeryShortStandaloneMonthSymbols"
    public const val VERY_SHORT_WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterVeryShortWeekdaySymbols"
    public const val STANDALONE_WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterStandaloneWeekdaySymbols"
    public const val SHORT_STANDALONE_WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortStandaloneWeekdaySymbols"
    public const val VERY_SHORT_STANDALONE_WEEKDAY_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterVeryShortStandaloneWeekdaySymbols"
    public const val QUARTER_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterQuarterSymbols"
    public const val SHORT_QUARTER_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortQuarterSymbols"
    public const val STANDALONE_QUARTER_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterStandaloneQuarterSymbols"
    public const val SHORT_STANDALONE_QUARTER_SYMBOLS: CFDateFormatterKey = "kCFDateFormatterShortStandaloneQuarterSymbols"
    public const val GREGORIAN_START_DATE: CFDateFormatterKey = "kCFDateFormatterGregorianStartDate"
    public const val DOES_RELATIVE_DATE_FORMATTING_KEY: CFDateFormatterKey = "kCFDateFormatterDoesRelativeDateFormattingKey"
}
