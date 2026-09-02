// port-lint: source number_formatter.rs
package io.github.kotlinmania.corefoundationsys.numberformatter

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFNumberFormatter
public typealias CFNumberFormatterRef = __CFNumberFormatter

public typealias CFNumberFormatterKey = String
public typealias CFNumberFormatterStyle = CFIndex
public typealias CFNumberFormatterOptionFlags = CFOptionFlags
public typealias CFNumberFormatterRoundingMode = CFIndex
public typealias CFNumberFormatterPadPosition = CFIndex

public const val kCFNumberFormatterNoStyle: CFNumberFormatterStyle = 0
public const val kCFNumberFormatterDecimalStyle: CFNumberFormatterStyle = 1
public const val kCFNumberFormatterCurrencyStyle: CFNumberFormatterStyle = 2
public const val kCFNumberFormatterPercentStyle: CFNumberFormatterStyle = 3
public const val kCFNumberFormatterScientificStyle: CFNumberFormatterStyle = 4
public const val kCFNumberFormatterSpellOutStyle: CFNumberFormatterStyle = 5

public const val kCFNumberFormatterParseIntegersOnly: CFNumberFormatterOptionFlags = 1L

public const val kCFNumberFormatterRoundCeiling: CFNumberFormatterRoundingMode = 0
public const val kCFNumberFormatterRoundFloor: CFNumberFormatterRoundingMode = 1
public const val kCFNumberFormatterRoundDown: CFNumberFormatterRoundingMode = 2
public const val kCFNumberFormatterRoundUp: CFNumberFormatterRoundingMode = 3
public const val kCFNumberFormatterRoundHalfEven: CFNumberFormatterRoundingMode = 4
public const val kCFNumberFormatterRoundHalfDown: CFNumberFormatterRoundingMode = 5
public const val kCFNumberFormatterRoundHalfUp: CFNumberFormatterRoundingMode = 6

public const val kCFNumberFormatterPadBeforePrefix: CFNumberFormatterPadPosition = 0
public const val kCFNumberFormatterPadAfterPrefix: CFNumberFormatterPadPosition = 1
public const val kCFNumberFormatterPadBeforeSuffix: CFNumberFormatterPadPosition = 2
public const val kCFNumberFormatterPadAfterSuffix: CFNumberFormatterPadPosition = 3

public object CFNumberFormatter {
    public const val TYPE_ID: CFTypeID = 52L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val CURRENCY_CODE: CFNumberFormatterKey = "kCFNumberFormatterCurrencyCode"
    public const val DECIMAL_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterDecimalSeparator"
    public const val CURRENCY_DECIMAL_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterCurrencyDecimalSeparator"
    public const val ALWAYS_SHOW_DECIMAL_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterAlwaysShowDecimalSeparator"
    public const val GROUPING_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterGroupingSeparator"
    public const val USE_GROUPING_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterUseGroupingSeparator"
    public const val PERCENT_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterPercentSymbol"
    public const val ZERO_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterZeroSymbol"
    public const val NA_N_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterNaNSymbol"
    public const val INFINITY_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterInfinitySymbol"
    public const val MINUS_SIGN: CFNumberFormatterKey = "kCFNumberFormatterMinusSign"
    public const val PLUS_SIGN: CFNumberFormatterKey = "kCFNumberFormatterPlusSign"
    public const val CURRENCY_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterCurrencySymbol"
    public const val EXPONENT_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterExponentSymbol"
    public const val MIN_INTEGER_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMinIntegerDigits"
    public const val MAX_INTEGER_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMaxIntegerDigits"
    public const val MIN_FRACTION_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMinFractionDigits"
    public const val MAX_FRACTION_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMaxFractionDigits"
    public const val GROUPING_SIZE: CFNumberFormatterKey = "kCFNumberFormatterGroupingSize"
    public const val SECONDARY_GROUPING_SIZE: CFNumberFormatterKey = "kCFNumberFormatterSecondaryGroupingSize"
    public const val ROUNDING_MODE: CFNumberFormatterKey = "kCFNumberFormatterRoundingMode"
    public const val ROUNDING_INCREMENT: CFNumberFormatterKey = "kCFNumberFormatterRoundingIncrement"
    public const val FORMAT_WIDTH: CFNumberFormatterKey = "kCFNumberFormatterFormatWidth"
    public const val PADDING_POSITION: CFNumberFormatterKey = "kCFNumberFormatterPaddingPosition"
    public const val PADDING_CHARACTER: CFNumberFormatterKey = "kCFNumberFormatterPaddingCharacter"
    public const val DEFAULT_FORMAT: CFNumberFormatterKey = "kCFNumberFormatterDefaultFormat"
    public const val MULTIPLIER: CFNumberFormatterKey = "kCFNumberFormatterMultiplier"
    public const val POSITIVE_PREFIX: CFNumberFormatterKey = "kCFNumberFormatterPositivePrefix"
    public const val POSITIVE_SUFFIX: CFNumberFormatterKey = "kCFNumberFormatterPositiveSuffix"
    public const val NEGATIVE_PREFIX: CFNumberFormatterKey = "kCFNumberFormatterNegativePrefix"
    public const val NEGATIVE_SUFFIX: CFNumberFormatterKey = "kCFNumberFormatterNegativeSuffix"
    public const val PER_MILL_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterPerMillSymbol"
    public const val INTERNATIONAL_CURRENCY_SYMBOL: CFNumberFormatterKey = "kCFNumberFormatterInternationalCurrencySymbol"
    public const val CURRENCY_GROUPING_SEPARATOR: CFNumberFormatterKey = "kCFNumberFormatterCurrencyGroupingSeparator"
    public const val IS_LENIENT: CFNumberFormatterKey = "kCFNumberFormatterIsLenient"
    public const val USE_SIGNIFICANT_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterUseSignificantDigits"
    public const val MIN_SIGNIFICANT_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMinSignificantDigits"
    public const val MAX_SIGNIFICANT_DIGITS: CFNumberFormatterKey = "kCFNumberFormatterMaxSignificantDigits"
}
