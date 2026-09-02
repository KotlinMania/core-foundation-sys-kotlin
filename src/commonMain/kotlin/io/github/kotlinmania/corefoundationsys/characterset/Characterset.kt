// port-lint: source characterset.rs
package io.github.kotlinmania.corefoundationsys.characterset

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFCharacterSet
public typealias CFCharacterSetRef = __CFCharacterSet
public typealias CFMutableCharacterSetRef = __CFCharacterSet

public typealias CFCharacterSetPredefinedSet = CFIndex

public const val kCFCharacterSetControl: CFCharacterSetPredefinedSet = 1
public const val kCFCharacterSetWhitespace: CFCharacterSetPredefinedSet = 2
public const val kCFCharacterSetWhitespaceAndNewline: CFCharacterSetPredefinedSet = 3
public const val kCFCharacterSetDecimalDigit: CFCharacterSetPredefinedSet = 4
public const val kCFCharacterSetLetter: CFCharacterSetPredefinedSet = 5
public const val kCFCharacterSetLowercaseLetter: CFCharacterSetPredefinedSet = 6
public const val kCFCharacterSetUppercaseLetter: CFCharacterSetPredefinedSet = 7
public const val kCFCharacterSetNonBase: CFCharacterSetPredefinedSet = 8
public const val kCFCharacterSetDecomposable: CFCharacterSetPredefinedSet = 9
public const val kCFCharacterSetAlphaNumeric: CFCharacterSetPredefinedSet = 10
public const val kCFCharacterSetPunctuation: CFCharacterSetPredefinedSet = 11
public const val kCFCharacterSetIllegal: CFCharacterSetPredefinedSet = 12
public const val kCFCharacterSetCapitalizedLetter: CFCharacterSetPredefinedSet = 13
public const val kCFCharacterSetSymbol: CFCharacterSetPredefinedSet = 14
public const val kCFCharacterSetNewline: CFCharacterSetPredefinedSet = 15

public object CFCharacterSet {
    public const val TYPE_ID: CFTypeID = 25L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
