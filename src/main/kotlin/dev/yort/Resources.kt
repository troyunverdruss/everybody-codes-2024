package dev.yort

object Resources {
    fun lines(fileName: String): List<String> =
        this::class.java
            .getResource("/inputs/$fileName")!!
            .readText()
            .split("\n")
}
