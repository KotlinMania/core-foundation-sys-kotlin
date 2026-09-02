// port-lint: source binary_heap.rs
package io.github.kotlinmania.corefoundationsys.binaryheap

import io.github.kotlinmania.corefoundationsys.base.CFComparisonResult
import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFBinaryHeap
public typealias CFBinaryHeapRef = __CFBinaryHeap

public data class CFBinaryHeapCompareContext(
    public val version: CFIndex = 0,
    public val info: Any? = null,
    public val retain: ((info: Any?) -> Any?)? = null,
    public val release: ((info: Any?) -> Unit)? = null,
    public val copyDescription: ((info: Any?) -> Any?)? = null,
)

public data class CFBinaryHeapCallBacks(
    public val version: CFIndex = 0,
    public val retain: ((allocator: Any?, ptr: Any?) -> Any?)? = null,
    public val release: ((allocator: Any?, ptr: Any?) -> Unit)? = null,
    public val copyDescription: ((ptr: Any?) -> Any?)? = null,
    public val compare: ((ptr1: Any?, ptr2: Any?, context: Any?) -> CFComparisonResult)? = null,
)

public typealias CFBinaryHeapApplierFunction = (value: Any?, context: Any?) -> Unit

public object CFBinaryHeap {
    public const val TYPE_ID: CFTypeID = 22L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
