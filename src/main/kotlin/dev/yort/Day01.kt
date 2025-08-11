package dev.yort

object Day01 {
    fun part1() {
        val totalCost =
            Resources
                .lines("d01.1.txt")
                .first()
                .mapNotNull { potionCost(it) }
                .sum()
        println(totalCost)
    }

    fun part2() {
        val totalCost =
            Resources
                .lines("d01.2.txt")
                .first()
                .asIterable()
                .windowed(2, step = 2)
                .sumOf { potionCostForGroup(it) }
        println(totalCost)
    }

    fun part3() {
        val totalCost =
            Resources
                .lines("d01.3.txt")
                .first()
                .asIterable()
                .windowed(3, step = 3)
                .sumOf { potionCostForGroup(it) }
        println(totalCost)
    }

    fun potionCostForGroup(creatures: List<Char>): Int {
        val costs = creatures.map { potionCost(it) }
        val creatureCount = costs.count { it != null }
        return when (creatureCount) {
            3 -> costs.filterNotNull().sum() + 6
            2 -> costs.filterNotNull().sum() + 2
            1 -> costs.filterNotNull().sum()
            0 -> 0
            else -> error("Invalid creature count $creatures")
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
