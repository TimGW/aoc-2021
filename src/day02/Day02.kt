package day02

import readInput

fun main() {
    fun splitInput(input: List<String>) = input.map { it.split(" ") }

    fun part1(input: List<String>): Int {
        var y = 0 // depth
        var x = 0 // horizontal position

        splitInput(input).forEach {
            val speed = it.last().toInt()

            when (it.first()) {
                "forward" -> x += speed
                "up" -> y -= speed
                "down" -> y += speed
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var y = 0 // depth
        var x = 0 // horizontal position
        var aim = 0

        splitInput(input).forEach {
            val speed = it.last().toInt()

            when (it.first()) {
                "forward" -> {
                    x += speed
                    y += (aim * speed)
                }
                "up" -> aim -= speed
                "down" -> aim += speed
            }
        }

        return x * y
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
