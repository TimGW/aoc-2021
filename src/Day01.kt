fun main() {
    fun part1(input: List<String>): Int {
        val numberInput = input.map { it.toInt() }
        val iterator = numberInput.listIterator(1) // skip first index since it has no previous
        var counter = 0

        while (iterator.hasNext()) if (numberInput[iterator.previousIndex()] < iterator.next()) counter++

        return counter
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
