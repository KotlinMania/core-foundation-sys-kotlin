// port-lint: source propertylist.rs
package io.github.kotlinmania.corefoundationsys.propertylist

import io.github.kotlinmania.corefoundationsys.base.CFIndex
import io.github.kotlinmania.corefoundationsys.base.CFOptionFlags

public typealias CFPropertyListRef = Any

/**
 * `CFPropertyListFormat` from CoreFoundation's `propertylist.rs` (upstream `pub type CFPropertyListFormat = CFIndex`).
 */
public typealias CFPropertyListFormat = CFIndex

public const val kCFPropertyListOpenStepFormat: CFPropertyListFormat = 1
public const val kCFPropertyListXMLFormat_v1_0: CFPropertyListFormat = 100
public const val kCFPropertyListBinaryFormat_v1_0: CFPropertyListFormat = 200

/**
 * `CFPropertyListMutabilityOptions` from CoreFoundation's `propertylist.rs` (upstream `pub type CFPropertyListMutabilityOptions = CFOptionFlags`).
 */
public typealias CFPropertyListMutabilityOptions = CFOptionFlags

public const val kCFPropertyListImmutable: CFPropertyListMutabilityOptions = 0L
public const val kCFPropertyListMutableContainers: CFPropertyListMutabilityOptions = 1L
public const val kCFPropertyListMutableContainersAndLeaves: CFPropertyListMutabilityOptions = 2L
