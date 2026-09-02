// port-lint: source xml_node.rs
package io.github.kotlinmania.corefoundationsys.xmlnode

import io.github.kotlinmania.corefoundationsys.array.CFArrayRef
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID
import io.github.kotlinmania.corefoundationsys.dictionary.CFDictionaryRef
import io.github.kotlinmania.corefoundationsys.string.CFStringEncoding
import io.github.kotlinmania.corefoundationsys.tree.CFTreeRef
import io.github.kotlinmania.corefoundationsys.url.CFURLRef

public class __CFXMLNode
public typealias CFXMLNodeRef = __CFXMLNode
public typealias CFXMLTreeRef = CFTreeRef

public const val kCFXMLNodeCurrentVersion: CFIndex = 1

public typealias CFXMLNodeTypeCode = CFIndex
public const val kCFXMLNodeTypeDocument: CFXMLNodeTypeCode = 1
public const val kCFXMLNodeTypeElement: CFXMLNodeTypeCode = 2
public const val kCFXMLNodeTypeAttribute: CFXMLNodeTypeCode = 3
public const val kCFXMLNodeTypeProcessingInstruction: CFXMLNodeTypeCode = 4
public const val kCFXMLNodeTypeComment: CFXMLNodeTypeCode = 5
public const val kCFXMLNodeTypeText: CFXMLNodeTypeCode = 6
public const val kCFXMLNodeTypeCDATASection: CFXMLNodeTypeCode = 7
public const val kCFXMLNodeTypeDocumentFragment: CFXMLNodeTypeCode = 8
public const val kCFXMLNodeTypeEntity: CFXMLNodeTypeCode = 9
public const val kCFXMLNodeTypeEntityReference: CFXMLNodeTypeCode = 10
public const val kCFXMLNodeTypeDocumentType: CFXMLNodeTypeCode = 11
public const val kCFXMLNodeTypeWhitespace: CFXMLNodeTypeCode = 12
public const val kCFXMLNodeTypeNotation: CFXMLNodeTypeCode = 13
public const val kCFXMLNodeTypeElementTypeDeclaration: CFXMLNodeTypeCode = 14
public const val kCFXMLNodeTypeAttributeListDeclaration: CFXMLNodeTypeCode = 15

public data class CFXMLElementInfo(
    public val attributes: CFDictionaryRef? = null,
    public val attributeOrder: CFArrayRef? = null,
    public val isEmpty: Boolean = false,
)

public data class CFXMLProcessingInstructionInfo(
    public val dataString: String? = null,
)

public data class CFXMLDocumentInfo(
    public val sourceURL: CFURLRef? = null,
    public val encoding: CFStringEncoding = 0u,
)

public data class CFXMLExternalID(
    public val systemID: CFURLRef? = null,
    public val publicID: String? = null,
)

public data class CFXMLDocumentTypeInfo(
    public val externalID: CFXMLExternalID = CFXMLExternalID(),
)

public data class CFXMLNotationInfo(
    public val externalID: CFXMLExternalID = CFXMLExternalID(),
)

public data class CFXMLElementTypeDeclarationInfo(
    public val contentDescription: String? = null,
)

public data class CFXMLAttributeDeclarationInfo(
    public val attributeName: String? = null,
    public val typeString: String? = null,
    public val defaultString: String? = null,
)

public data class CFXMLAttributeListDeclarationInfo(
    public val numberOfAttributes: CFIndex = 0,
    public val attributes: List<CFXMLAttributeDeclarationInfo> = emptyList(),
)

public typealias CFXMLEntityTypeCode = CFIndex
public const val kCFXMLEntityTypeParameter: CFXMLEntityTypeCode = 0
public const val kCFXMLEntityTypeParsedInternal: CFXMLEntityTypeCode = 1
public const val kCFXMLEntityTypeParsedExternal: CFXMLEntityTypeCode = 2
public const val kCFXMLEntityTypeUnparsed: CFXMLEntityTypeCode = 3
public const val kCFXMLEntityTypeCharacter: CFXMLEntityTypeCode = 4

public data class CFXMLEntityInfo(
    public val entityType: CFXMLEntityTypeCode = 0,
    public val replacementText: String? = null,
    public val entityID: CFXMLExternalID = CFXMLExternalID(),
    public val notationName: String? = null,
)

public data class CFXMLEntityReferenceInfo(
    public val entityType: CFXMLEntityTypeCode = 0,
)

public object CFXMLNode {
    public const val TYPE_ID: CFTypeID = 58L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
