private const val DISTINCT_CHARACTERS_PART_1 = 4
private const val DISTINCT_CHARACTERS_PART_2 = 14

class Day06(val input: String) {
    fun part1() = startOfMessageMarker(DISTINCT_CHARACTERS_PART_1)

    fun part2() = startOfMessageMarker(DISTINCT_CHARACTERS_PART_2)

    private fun startOfMessageMarker(windowSize: Int): Int {
        val windowed = input.windowed(windowSize)
        for ((index, window) in windowed.withIndex()) {
            if (window.toSet().count() == window.length) {
                return index + window.length
            }
        }
        return -1
    }
}

fun main() {
    println(Day06(readInput("Day06").first()).part1())
    println(Day06(readInput("Day06").first()).part2())
}
