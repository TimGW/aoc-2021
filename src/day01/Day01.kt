package day01

import readIntInput

fun main() {
    fun part1(input: List<Int>) = input.windowed(2).count { it.last() > it.first() }

    fun part2(input: List<Int>) = part1(input.windowed(3).map { it.sum() })

    // test if implementation meets criteria from the description, like:
    val testInput = readIntInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readIntInput("Day01")
    println(part1(input))
    println(part2(input))
}
