class Day03 {
    fun split(input: String): Pair<String, String> {
        val mid = input.length / 2
        return input.take(mid) to input.substring(mid)
    }

    fun appearsInBoth(left: String, right: String) =
        "[$right]".toRegex()
            .findAll(left)
            .map { it.value }
            .toSet()
            .joinToString(separator = "")

    fun calculatePriority(input: String) =
        input.toCharArray().filter { ('a'..'z').contains(it) }.map { it.code - 'a'.code + 1 }.sum() +
                input.toCharArray().filter { ('A'..'Z').contains(it) }.map { it.code - 'A'.code + 27 }.sum()


    fun part1(input: List<String>) = input
        .map { split(it) }
        .map { appearsInBoth(it.first, it.second) }
        .sumOf { calculatePriority(it) }

    fun part2(input: List<String>) = input
        .chunked(3)
        .map { appearsInBoth(appearsInBoth(it[0], it[1]), it[2]) }
        .sumOf { calculatePriority(it)}
}

fun main() {
    val input = readInput("Day03")
    println(Day03().part1(input))
    println(Day03().part2(input))
}
