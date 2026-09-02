// port-lint: source locale.rs
package io.github.kotlinmania.corefoundationsys.locale

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFLocale
public typealias CFLocaleRef = __CFLocale

public typealias CFLocaleIdentifier = String
public typealias CFLocaleKey = String
public typealias CFCalendarIdentifier = String
public typealias CFLocaleLanguageDirection = CFIndex

public const val kCFLocaleLanguageDirectionUnknown: CFLocaleLanguageDirection = 0
public const val kCFLocaleLanguageDirectionLeftToRight: CFLocaleLanguageDirection = 1
public const val kCFLocaleLanguageDirectionRightToLeft: CFLocaleLanguageDirection = 2
public const val kCFLocaleLanguageDirectionTopToBottom: CFLocaleLanguageDirection = 3
public const val kCFLocaleLanguageDirectionBottomToTop: CFLocaleLanguageDirection = 4

public object CFLocale {
    public const val TYPE_ID: CFTypeID = 37L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val CURRENT_LOCALE_DID_CHANGE_NOTIFICATION: String = "kCFLocaleCurrentLocaleDidChangeNotification"

    public const val IDENTIFIER: CFLocaleKey = "kCFLocaleIdentifier"
    public const val LANGUAGE_CODE: CFLocaleKey = "kCFLocaleLanguageCode"
    public const val COUNTRY_CODE: CFLocaleKey = "kCFLocaleCountryCode"
    public const val SCRIPT_CODE: CFLocaleKey = "kCFLocaleScriptCode"
    public const val VARIANT_CODE: CFLocaleKey = "kCFLocaleVariantCode"
    public const val EXEMPLAR_CHARACTER_SET: CFLocaleKey = "kCFLocaleExemplarCharacterSet"
    public const val CALENDAR_IDENTIFIER: CFLocaleKey = "kCFLocaleCalendarIdentifier"
    public const val CALENDAR: CFLocaleKey = "kCFLocaleCalendar"
    public const val COLLATION_IDENTIFIER: CFLocaleKey = "kCFLocaleCollationIdentifier"
    public const val USES_METRIC_SYSTEM: CFLocaleKey = "kCFLocaleUsesMetricSystem"
    public const val MEASUREMENT_SYSTEM: CFLocaleKey = "kCFLocaleMeasurementSystem"
    public const val DECIMAL_SEPARATOR: CFLocaleKey = "kCFLocaleDecimalSeparator"
    public const val GROUPING_SEPARATOR: CFLocaleKey = "kCFLocaleGroupingSeparator"
    public const val CURRENCY_SYMBOL: CFLocaleKey = "kCFLocaleCurrencySymbol"
    public const val CURRENCY_CODE: CFLocaleKey = "kCFLocaleCurrencyCode"
    public const val COLLATOR_IDENTIFIER: CFLocaleKey = "kCFLocaleCollatorIdentifier"
    public const val QUOTATION_BEGIN_DELIMITER_KEY: CFLocaleKey = "kCFLocaleQuotationBeginDelimiterKey"
    public const val QUOTATION_END_DELIMITER_KEY: CFLocaleKey = "kCFLocaleQuotationEndDelimiterKey"
    public const val ALTERNATE_QUOTATION_BEGIN_DELIMITER_KEY: CFLocaleKey = "kCFLocaleAlternateQuotationBeginDelimiterKey"
    public const val ALTERNATE_QUOTATION_END_DELIMITER_KEY: CFLocaleKey = "kCFLocaleAlternateQuotationEndDelimiterKey"

    public const val GREGORIAN_CALENDAR: CFCalendarIdentifier = "kCFGregorianCalendar"
    public const val BUDDHIST_CALENDAR: CFCalendarIdentifier = "kCFBuddhistCalendar"
    public const val CHINESE_CALENDAR: CFCalendarIdentifier = "kCFChineseCalendar"
    public const val HEBREW_CALENDAR: CFCalendarIdentifier = "kCFHebrewCalendar"
    public const val ISLAMIC_CALENDAR: CFCalendarIdentifier = "kCFIslamicCalendar"
    public const val ISLAMIC_CIVIL_CALENDAR: CFCalendarIdentifier = "kCFIslamicCivilCalendar"
    public const val JAPANESE_CALENDAR: CFCalendarIdentifier = "kCFJapaneseCalendar"
    public const val REPUBLIC_OF_CHINA_CALENDAR: CFCalendarIdentifier = "kCFRepublicOfChinaCalendar"
    public const val PERSIAN_CALENDAR: CFCalendarIdentifier = "kCFPersianCalendar"
    public const val INDIAN_CALENDAR: CFCalendarIdentifier = "kCFIndianCalendar"
    public const val ISO8601_CALENDAR: CFCalendarIdentifier = "kCFISO8601Calendar"
}
