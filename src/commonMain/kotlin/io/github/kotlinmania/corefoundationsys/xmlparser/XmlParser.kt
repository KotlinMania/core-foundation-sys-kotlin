// port-lint: source xml_parser.rs
package io.github.kotlinmania.corefoundationsys.xmlparser

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.data.CFDataRef
import io.github.kotlinmania.corefoundationsys.xmlnode.CFXMLExternalID
import io.github.kotlinmania.corefoundationsys.xmlnode.CFXMLNodeRef

public class __CFXMLParser
public typealias CFXMLParserRef = __CFXMLParser

public typealias CFXMLParserOptions = CFOptionFlags
public const val kCFXMLParserValidateDocument: CFXMLParserOptions = 1L shl 0
public const val kCFXMLParserSkipMetaData: CFXMLParserOptions = 1L shl 1
public const val kCFXMLParserReplacePhysicalEntities: CFXMLParserOptions = 1L shl 2
public const val kCFXMLParserSkipWhitespace: CFXMLParserOptions = 1L shl 3
public const val kCFXMLParserResolveExternalEntities: CFXMLParserOptions = 1L shl 4
public const val kCFXMLParserAddImpliedAttributes: CFXMLParserOptions = 1L shl 5
public const val kCFXMLParserAllOptions: CFXMLParserOptions = 0x00FFFFFFL
public const val kCFXMLParserNoOptions: CFXMLParserOptions = 0L

public typealias CFXMLParserStatusCode = CFIndex
public const val kCFXMLStatusParseNotBegun: CFIndex = -2
public const val kCFXMLStatusParseInProgress: CFIndex = -1
public const val kCFXMLStatusParseSuccessful: CFIndex = 0
public const val kCFXMLErrorUnexpectedEOF: CFIndex = 1
public const val kCFXMLErrorUnknownEncoding: CFIndex = 2
public const val kCFXMLErrorEncodingConversionFailure: CFIndex = 3
public const val kCFXMLErrorMalformedProcessingInstruction: CFIndex = 4
public const val kCFXMLErrorMalformedDTD: CFIndex = 5
public const val kCFXMLErrorMalformedName: CFIndex = 6
public const val kCFXMLErrorMalformedCDSect: CFIndex = 7
public const val kCFXMLErrorMalformedCloseTag: CFIndex = 8
public const val kCFXMLErrorMalformedStartTag: CFIndex = 9
public const val kCFXMLErrorMalformedDocument: CFIndex = 10
public const val kCFXMLErrorElementlessDocument: CFIndex = 11
public const val kCFXMLErrorMalformedComment: CFIndex = 12
public const val kCFXMLErrorMalformedCharacterReference: CFIndex = 13
public const val kCFXMLErrorMalformedParsedCharacterData: CFIndex = 14
public const val kCFXMLErrorNoData: CFIndex = 15

public typealias CFXMLParserCreateXMLStructureCallBack = (parser: CFXMLParserRef?, nodeDesc: CFXMLNodeRef?, info: Any?) -> Any?
public typealias CFXMLParserAddChildCallBack = (parser: CFXMLParserRef?, parent: Any?, child: Any?, info: Any?) -> Unit
public typealias CFXMLParserEndXMLStructureCallBack = (parser: CFXMLParserRef?, xmlType: Any?, info: Any?) -> Unit
public typealias CFXMLParserResolveExternalEntityCallBack = (parser: CFXMLParserRef?, extID: CFXMLExternalID?, info: Any?) -> CFDataRef?
public typealias CFXMLParserHandleErrorCallBack = (parser: CFXMLParserRef?, error: CFXMLParserStatusCode, info: Any?) -> Boolean

public data class CFXMLParserCallBacks(
    public val version: CFIndex = 0,
    public val createXMLStructure: CFXMLParserCreateXMLStructureCallBack? = null,
    public val addChild: CFXMLParserAddChildCallBack? = null,
    public val endXMLStructure: CFXMLParserEndXMLStructureCallBack? = null,
    public val resolveExternalEntity: CFXMLParserResolveExternalEntityCallBack? = null,
    public val handleError: CFXMLParserHandleErrorCallBack? = null,
)

public typealias CFXMLParserRetainCallBack = (info: Any?) -> Any?
public typealias CFXMLParserReleaseCallBack = (info: Any?) -> Unit
public typealias CFXMLParserCopyDescriptionCallBack = (info: Any?) -> String?

public data class CFXMLParserContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: CFXMLParserRetainCallBack? = null,
    public val release: CFXMLParserReleaseCallBack? = null,
    public val copyDescription: CFXMLParserCopyDescriptionCallBack? = null,
)

public object CFXMLParser {
    public const val TYPE_ID: CFTypeID = 59L

    public fun getTypeID(): CFTypeID = TYPE_ID

    public const val TREE_ERROR_DESCRIPTION: String = "kCFXMLTreeErrorDescription"
    public const val TREE_ERROR_LINE_NUMBER: String = "kCFXMLTreeErrorLineNumber"
    public const val TREE_ERROR_LOCATION: String = "kCFXMLTreeErrorLocation"
    public const val TREE_ERROR_STATUS_CODE: String = "kCFXMLTreeErrorStatusCode"
}
