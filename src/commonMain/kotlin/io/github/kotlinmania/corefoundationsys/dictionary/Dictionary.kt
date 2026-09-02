// port-lint: source dictionary.rs
package io.github.kotlinmania.corefoundationsys.dictionary

import io.github.kotlinmania.corefoundationsys.base.CFBoolean
import io.github.kotlinmania.corefoundationsys.base.CFHashCode
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFDictionary
public typealias CFDictionaryRef = __CFDictionary
public typealias CFMutableDictionaryRef = __CFDictionary

public typealias CFDictionaryApplierFunction = (key: Any?, value: Any?, context: Any?) -> Unit
public typealias CFDictionaryRetainCallBack = (allocator: Any?, value: Any?) -> Any?
public typealias CFDictionaryReleaseCallBack = (allocator: Any?, value: Any?) -> Unit
public typealias CFDictionaryCopyDescriptionCallBack = (value: Any?) -> Any?
public typealias CFDictionaryEqualCallBack = (value1: Any?, value2: Any?) -> CFBoolean
public typealias CFDictionaryHashCallBack = (value: Any?) -> CFHashCode

public data class CFDictionaryKeyCallBacks(
    public val version: CFIndex = 0,
    public val retain: CFDictionaryRetainCallBack? = null,
    public val release: CFDictionaryReleaseCallBack? = null,
    public val copyDescription: CFDictionaryCopyDescriptionCallBack? = null,
    public val equal: CFDictionaryEqualCallBack? = null,
    public val hash: CFDictionaryHashCallBack? = null,
)

public data class CFDictionaryValueCallBacks(
    public val version: CFIndex = 0,
    public val retain: CFDictionaryRetainCallBack? = null,
    public val release: CFDictionaryReleaseCallBack? = null,
    public val copyDescription: CFDictionaryCopyDescriptionCallBack? = null,
    public val equal: CFDictionaryEqualCallBack? = null,
)

public object CFDictionary {
    public const val TYPE_ID: CFTypeID = 19L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
