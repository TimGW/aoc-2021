package day04

import readInput

fun main() {

    fun buildBingoCards(
        input: List<String>,
        delimiter: String = " "
    ) = input
        .filter { it.isNotBlank() }
        .chunked(5)
        .map { bingoCard ->
            bingoCard.map { row ->
                row.trim() // remove front and end extra whitespace
                    .replace("\\s+".toRegex(), delimiter) // remove additional whitespace between columns
                    .split(delimiter) // split into sub array
                    .associateBy({ it }, { false }) // set default false value to indicate the number is not yet drawn
                    .toMutableMap() as LinkedHashMap
            }
        }

    fun List<LinkedHashMap<String, Boolean>>.transpose(): List<Map<String, Boolean>> {
        val columnSize = size
        val rowSize = first().size
        val transposedMatrix = List(columnSize) { LinkedHashMap<String, Boolean>() }

       repeat(rowSize) { rowIndex ->
           repeat(columnSize) { columnIndex ->
               val columnKey = this[rowIndex].keys.elementAt(columnIndex)
               val rowKey = this[columnIndex].keys.elementAt(rowIndex)
               transposedMatrix[columnIndex][rowKey] = this[rowIndex][columnKey] ?: false
            }
        }

        return transposedMatrix
    }

    fun isRowComplete(
        row: Map<String, Boolean>
    ): Boolean {
        if (row.all { it.value }) return true
        return false
    }

    fun isColumnComplete(
        bingoCard: List<LinkedHashMap<String, Boolean>>
    ): Boolean {
        bingoCard.transpose().forEach { return isRowComplete(it) }
        return false
    }

    fun calcFinalScore(
        winningBingoCard: List<LinkedHashMap<String, Boolean>>?,
        lastCalledNumber: String?
    ) = winningBingoCard
        ?.flatMap { it.entries }
        ?.sumOf { if (!it.value) it.key.toInt() else 0 }
        ?.times(lastCalledNumber?.toInt() ?: 1)

    fun separateInput(
        input: List<String>
    ): List<List<String>> = input
        .withIndex()
        .groupBy { it.index == 0 }
        .map { entry ->
            val first = entry.value[0]

            if (first.index == 0) {
                first.value.split(",")
            } else {
                entry.value.map { it.value }
            }
        }

    fun part1(input: List<String>) {
        val (drawnNumbers, rawBingoCards) = separateInput(input)
        val bingoCards = buildBingoCards(rawBingoCards)

        drawnNumbers.forEach { drawnNumber ->
            bingoCards.forEach { currentBingoCard ->
                currentBingoCard.forEach { currentRow ->
                    if (currentRow.containsKey(drawnNumber)) currentRow[drawnNumber] = true

                    if (isColumnComplete(currentBingoCard) || isRowComplete(currentRow)) {
                        println(calcFinalScore(currentBingoCard, drawnNumber))
                        return@part1
                    }
                }
            }
        }
    }

    part1(readInput("Day04"))
}

