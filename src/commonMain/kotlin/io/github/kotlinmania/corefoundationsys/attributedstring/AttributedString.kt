// port-lint: source attributed_string.rs
package io.github.kotlinmania.corefoundationsys.attributedstring

import io.github.kotlinmania.corefoundationsys.base.CFTypeID

public class __CFAttributedString
public typealias CFAttributedStringRef = __CFAttributedString
public typealias CFMutableAttributedStringRef = __CFAttributedString

public object CFAttributedString {
    public const val TYPE_ID: CFTypeID = 48L

    public fun getTypeID(): CFTypeID = TYPE_ID
}
