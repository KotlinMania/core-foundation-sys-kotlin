// port-lint: source string_tokenizer.rs
package io.github.kotlinmania.corefoundationsys.stringtokenizer

import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFStringTokenizer
public typealias CFStringTokenizerRef = __CFStringTokenizer

public typealias CFStringTokenizerTokenType = CFOptionFlags

public const val kCFStringTokenizerTokenNone: CFStringTokenizerTokenType = 0L
public const val kCFStringTokenizerTokenNormal: CFStringTokenizerTokenType = 1L shl 0
public const val kCFStringTokenizerTokenHasSubTokensMask: CFStringTokenizerTokenType = 1L shl 1
public const val kCFStringTokenizerTokenHasDerivedSubTokensMask: CFStringTokenizerTokenType = 1L shl 2
public const val kCFStringTokenizerTokenHasHasNumbersMask: CFStringTokenizerTokenType = 1L shl 3
public const val kCFStringTokenizerTokenHasNonLettersMask: CFStringTokenizerTokenType = 1L shl 4
public const val kCFStringTokenizerTokenIsCJWordMask: CFStringTokenizerTokenType = 1L shl 5

public const val kCFStringTokenizerUnitWord: CFOptionFlags = 0L
public const val kCFStringTokenizerUnitSentence: CFOptionFlags = 1L
public const val kCFStringTokenizerUnitParagraph: CFOptionFlags = 2L
public const val kCFStringTokenizerUnitLineBreak: CFOptionFlags = 3L
public const val kCFStringTokenizerUnitWordBoundary: CFOptionFlags = 4L
public const val kCFStringTokenizerAttributeLatinTranscription: CFOptionFlags = 1L shl 16
public const val kCFStringTokenizerAttributeLanguage: CFOptionFlags = 1L shl 17

public object CFStringTokenizer {
    public const val TYPE_ID: CFTypeID = 55L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
