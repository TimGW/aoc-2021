package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var y = 0 // depth
        var x = 0 // horizontal position

        input.map {
            it.split(" ")
        }.forEach {
            val speed = it.last().toInt()

            when (it.first()) {
                "forward" -> x += speed
                "up" -> y -= speed
                "down" -> y += speed
            }
        }

        return x * y
    }

    val input = readInput("Day02")
    println(part1(input))
}
