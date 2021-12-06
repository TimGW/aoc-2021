fun main() {
    fun part1(input: List<Int>): Int {
        val iterator = input.listIterator(1) // skip first index since it has no previous
        var counter = 0

        while (iterator.hasNext()) if (input[iterator.previousIndex()] < iterator.next()) counter++

        return counter
    }

    fun part2(input: List<Int>) = input
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { it.last() > it.first() }

    // test if implementation meets criteria from the description, like:
    val testInput = readIntInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readIntInput("Day01")
    println(part1(input))
    println(part2(input))
}
