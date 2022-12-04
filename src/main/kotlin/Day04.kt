class Day04 {
    companion object {
        data class RoundComponents(val left: IntRange, val right: IntRange)

        private fun parseInput(round: String): RoundComponents {
            val (leftStart, leftEnd, rightStart, rightEnd) = round.replace(",", "-").split("-")
                .map { it.trim().toInt() }
            return RoundComponents(leftStart..leftEnd, rightStart..rightEnd)
        }

        fun part1(input: List<String>): Int {
            fun isSubset(round: RoundComponents): Int {
                if (((round.left.first <= round.right.first) && (round.left.last >= round.right.last)) ||
                    ((round.right.first <= round.left.first) && (round.right.last >= round.left.last))
                ) {
                    return 1
                }
                return 0
            }

            return input.sumOf { round ->
                isSubset(parseInput(round))
            }
        }

        fun part2(input: List<String>): Int {
            fun overlaps(round: RoundComponents): Int {
                if ((round.left.minus(round.right)  == round.left.toList()))
                    return 0
                return 1
            }

            return input.sumOf { round ->
                overlaps(parseInput(round))
            }
        }
    }
}

fun main() {
    val input = readInput("Day04")
    println(Day04.part1(input))
    println(Day04.part2(input))
}
