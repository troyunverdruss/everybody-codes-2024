package dev.yort

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun testPart2() {
        assertEquals(
            5,
            Day01.potionCostForPair(listOf('x', 'D')),
        )
    }
}
