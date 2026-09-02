// port-lint: source url_enumerator.rs
package io.github.kotlinmania.corefoundationsys.urlenumerator

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFURLEnumerator
public typealias CFURLEnumeratorRef = __CFURLEnumerator

public typealias CFURLEnumeratorOptions = CFOptionFlags
public const val kCFURLEnumeratorDefaultBehavior: CFURLEnumeratorOptions = 0L
public const val kCFURLEnumeratorDescendRecursively: CFURLEnumeratorOptions = 1L shl 0
public const val kCFURLEnumeratorSkipInvisibles: CFURLEnumeratorOptions = 1L shl 1
public const val kCFURLEnumeratorGenerateFileReferenceURLs: CFURLEnumeratorOptions = 1L shl 2
public const val kCFURLEnumeratorSkipPackageContents: CFURLEnumeratorOptions = 1L shl 3
public const val kCFURLEnumeratorIncludeDirectoriesPreOrder: CFURLEnumeratorOptions = 1L shl 4
public const val kCFURLEnumeratorIncludeDirectoriesPostOrder: CFURLEnumeratorOptions = 1L shl 5

public typealias CFURLEnumeratorResult = CFIndex
public const val kCFURLEnumeratorSuccess: CFURLEnumeratorOptions = 1L
public const val kCFURLEnumeratorEnd: CFURLEnumeratorOptions = 2L
public const val kCFURLEnumeratorError: CFURLEnumeratorOptions = 3L
public const val kCFURLEnumeratorDirectoryPostOrderSuccess: CFURLEnumeratorOptions = 4L

public object CFURLEnumerator {
    public const val TYPE_ID: CFTypeID = 56L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
