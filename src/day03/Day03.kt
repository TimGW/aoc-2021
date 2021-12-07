package day03

import readInput

fun main() {

    fun getGammaValue(map: Set<Map.Entry<Char, Int>>) = map.maxByOrNull { it.value }?.key

    fun getEpsilonValue(map: Set<Map.Entry<Char, Int>>) = map.minByOrNull { it.value }?.key

    fun getBit(stringBuilder: StringBuilder) = stringBuilder.toString().toInt(2)

    fun calculateRate(input: List<String>): Pair<Int, Int> {
        val gammaRate = StringBuilder()
        val epsilonRate = StringBuilder()

        repeat(input.first().length) { index ->
            val numbersByElement = input.groupingBy { it[index] }.eachCount().entries
            gammaRate.append(getGammaValue(numbersByElement))
            epsilonRate.append(getEpsilonValue(numbersByElement))
        }

        return Pair(getBit(gammaRate), getBit(epsilonRate))
    }

    fun part1(input: List<String>): Int {
        val rate = calculateRate(input)
        return rate.first * rate.second
    }

    val input = readInput("Day03")

    println(part1(input))
}
