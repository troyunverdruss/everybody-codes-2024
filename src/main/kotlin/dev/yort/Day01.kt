package dev.yort

object Day01 {
    fun part1() {
        val totalCost =
            this::class.java
                .getResource("/inputs/d01.1.txt")!!
                .readText()
                .split("\n")
                .first()
                .mapNotNull { potionCost(it) }
                .sum()
        println(totalCost)
    }

    fun part2() {
        val totalCost =
            this::class.java
                .getResource("/inputs/d01.2.txt")!!
                .readText()
                .split("\n")
                .first()
                .asIterable()
                .windowed(2, step = 2)
                .map { potionCostForPair(it) }
                .also { println(it) }
                .sum()
        println(totalCost)
    }

    fun potionCostForPair(creatures: List<Char>): Int {
        val costs = creatures.map { potionCost(it) }
        return if (costs.contains(null)) {
            costs.filterNotNull().sum()
        } else {
            costs.filterNotNull().sum() + 2
        }
    }

    fun potionCost(creature: Char): Int? =
        when (creature) {
            'A' -> 0
            'B' -> 1
            'C' -> 3
            'D' -> 5
            'x' -> null
            else -> error("Invalid creature char $creature")
        }
}
