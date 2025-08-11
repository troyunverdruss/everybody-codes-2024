package dev.yort

object Day02 {
    fun part1() {
        val lines = Resources.lines("d02.1.txt")
        val runes = lines[0].split(":")[1].split(",")
        val phrase = lines[2]

        val count = runes.sumOf { rune -> phrase.windowed(rune.length).count { it == rune } }
        println(count)
    }

    fun part2() {
        val lines = Resources.lines("d02.2.txt")
        val runes = lines[0].split(":")[1].split(",")
        val phrases = lines.slice(2..<lines.size)

        val counts = doPart2(runes, phrases)
        println(counts)
    }

    fun doPart2(
        runes: List<String>,
        phrases: List<String>,
    ): Int {
        val countsPerPhrase =
            phrases
                .map { phrase ->
                    // Count of all included indexes for each phrase and each rune
                    runes.flatMap { rune -> getMatchingIndexesForPhaseBothWays(rune, phrase) }.toSet().size
                }

        return countsPerPhrase.sum()
    }

    fun getMatchingIndexesForPhaseBothWays(
        rune: String,
        phrase: String,
    ): Set<Int> {
        val matchedIndexes = getMatchingIndexesForPhrase(rune, phrase)
        val matchedIndexes2 = getMatchingIndexesForPhrase(rune, phrase, true)

        return (matchedIndexes + matchedIndexes2)
    }

    fun getMatchingIndexesForPhrase(
        rune: String,
        phrase: String,
        reversed: Boolean = false,
    ): Set<Int> {
        val phraseWithIndex =
            if (reversed) {
                phrase.withIndex().reversed()
            } else {
                phrase.withIndex()
            }

        val values =
            phraseWithIndex
                .windowed(rune.length) { p ->
                    val indexes = p.map { it.index }
                    val subPhrase = p.map { it.value }.joinToString("")
                    if (rune == subPhrase) {
                        indexes
                    } else {
                        emptyList()
                    }
                }.flatten()
                .toSet()
        return values
    }
}
