// port-lint: source data.rs
package io.github.kotlinmania.corefoundationsys.data

import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags

/**
 * `CFDataSearchFlags` from CoreFoundation's `data.rs` (upstream `pub type CFDataSearchFlags = CFOptionFlags`).
 */
public typealias CFDataSearchFlags = CFOptionFlags

public const val kCFDataSearchBackwards: CFDataSearchFlags = 1L
public const val kCFDataSearchAnchored: CFDataSearchFlags = 2L
