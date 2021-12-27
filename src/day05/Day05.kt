package day05

import readInput

data class Coordinate(val x: Int, val y: Int)

data class Line(val start: Coordinate, val end: Coordinate)

fun main() {

    fun buildMatrix(
        input: List<String>
    ): List<Line> = input.map {
        val coordinate = it.split(" -> ").map { value ->
            val point = value.split(",")
            Coordinate(point.first().toInt(), point.last().toInt())
        }
        Line(coordinate.first(), coordinate.last())
    }

    fun part1(input: List<String>) {
        val output = Array(1000) { Array(1000) { 0 } }

        buildMatrix(input).forEach { line ->
            // horizontal line
            if (line.start.y == line.end.y) {
                (minOf(line.start.x, line.end.x)..maxOf(line.start.x, line.end.x)).forEach {
                    output[line.start.y][it] = output[line.start.y][it] + 1
                }
            }
            // vertical line
            else if (line.start.x == line.end.x) {
                (minOf(line.start.y, line.end.y)..maxOf(line.start.y, line.end.y)).forEach {
                    output[it][line.start.x] = output[it][line.start.x] + 1
                }
            }
        }

        println(output.flatten().count { it > 1 })
    }

    // x1,y1 -> x2,y2
    part1(readInput("Day05"))
}

