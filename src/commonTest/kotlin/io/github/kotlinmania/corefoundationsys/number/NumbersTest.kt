// port-lint: tests number.rs
package io.github.kotlinmania.corefoundationsys.number

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumbersTest {
    @Test
    fun match_for_type_id_should_be_backwards_compatible() {
        val typeId = kCFNumberFloat32Type
        val matched = when (typeId) {
            kCFNumberFloat32Type -> true
            else -> false
        }
        assertTrue(matched)
        assertEquals(5u, typeId)
    }
}
