package day07

import readInput
import kotlin.math.absoluteValue

fun main() {

    fun Set<Int>.minOfRange(
        minimum: (Int) -> Int
    ) = (this.minOf { it }..this.maxOf { it }).minOf { minimum.invoke(it) }

    fun part1(
        crabs: Map<Int, Int>,
        fuel: (Int) -> Int
    ): Int = crabs.keys.minOfRange { minimum ->
        crabs.map { (crab, count) ->
            fuel((minimum - crab).absoluteValue) * count
        }.sum()
    }

    val result = part1(readInput("Day07")
        .first()
        .split(",")
        .map { it.toInt() }
        .groupingBy { it }
        .eachCount()) {
        it * 1 /** fuel only cost 1 unit */
    }

    println(result)
}




