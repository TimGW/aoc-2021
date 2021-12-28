package day06

import readInput

const val NO_OF_DAYS = 80

fun main() {

    fun dayDone(fishList: HashMap<Int, Int>): HashMap<Int, Int> {
        val result = fishList.toMutableMap()
        fishList.forEach { (index, oldValue) ->
            if (oldValue <= 0) {
                result[index] = 6
                result[result.size] = 8
            } else {
                result[index] = oldValue - 1
            }
        }
        return result as HashMap<Int, Int>
    }

    fun part1(input: List<String>) {
        val initialState: HashMap<Int, Int> = input
            .first()
            .split(",")
            .withIndex()
            .associateTo(hashMapOf()) { it.index to it.value.toInt() }

        var result: HashMap<Int, Int> = initialState

        repeat(NO_OF_DAYS) {
            val day = it + 1
            println("calculating day $day ")

            result = dayDone(result)
        }

        println("fish: ${result.size}")
    }

    part1(readInput("Day06"))
}


