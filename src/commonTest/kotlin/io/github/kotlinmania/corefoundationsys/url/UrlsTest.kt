// port-lint: tests url.rs
package io.github.kotlinmania.corefoundationsys.url

import kotlin.test.Test
import kotlin.test.assertEquals

class UrlsTest {
    @Test
    fun can_see_excluded_from_backup_key() {
        val key = kCFURLIsExcludedFromBackupKey
        assertEquals("NSURLIsExcludedFromBackupKey", key)
    }
}
