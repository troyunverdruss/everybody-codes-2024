
package dev.yort

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun `countMatchingIndexes 1`() {
        assertEquals(
            setOf(0, 1, 2, 3, 4),
            Day02.getMatchingIndexesForPhrase("QAQ", "QAQAQ"),
        )
    }

    @Test
    fun `countSymbolsInPhrase 1`() {
        assertEquals(
            setOf(17, 18, 19),
            Day02.getMatchingIndexesForPhaseBothWays("ROD", "AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE"),
        )
    }

    @Test
    fun `do part 2 with only 1`() {
        assertEquals(
            15,
            Day02.doPart2(
                listOf(
                    "THE",
                    "OWE",
                    "MES",
                    "ROD",
                    "HER",
                    "QAQ",
                ),
                listOf("AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE"),
            ),
        )
    }

    @Test
    fun `do part 2 with all inputs`() {
        assertEquals(
            42,
            Day02.doPart2(
                listOf(
                    "THE",
                    "OWE",
                    "MES",
                    "ROD",
                    "HER",
                    "QAQ",
                ),
                listOf(
                    "AWAKEN THE POWE ADORNED WITH THE FLAMES BRIGHT IRE",
                    "THE FLAME SHIELDED THE HEART OF THE KINGS",
                    "POWE PO WER P OWE R",
                    "THERE IS THE END",
                    "QAQAQ",
                ),
            ),
        )
    }
}
