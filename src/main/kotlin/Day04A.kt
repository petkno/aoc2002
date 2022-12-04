class Day04A(input: List<String>) {

    private val ranges: List<Pair<IntRange, IntRange>> = input.map { it.asRanges() }

    fun part1(): Int =
        ranges.count { it.first fullyOverlaps it.second || it.second fullyOverlaps it.first }

    fun part2(): Int = ranges.count { it.first overlaps it.second }

    private infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
        first <= other.first && last >= other.last

    private infix fun IntRange.overlaps(other: IntRange): Boolean =
        first <= other.last && other.first <= last

    private fun String.asRanges(): Pair<IntRange, IntRange> =
        substringBefore(",").asIntRanges() to substringAfter(",").asIntRanges()

    private fun String.asIntRanges(): IntRange =
        substringBefore("-").toInt()..substringAfter("-").toInt()
}

fun main() {
    val d = Day04A(readInput("Day04"))
    println(d.part1())
    println(d.part2())
}
