private const val SCORE_LOST = 0
private const val SCORE_DRAW = 3
private const val SCORE_WIN = 6

class Day02A {
    companion object {
        operator fun String.component1() = this[SCORE_LOST]
        operator fun String.component2() = this[1]
        operator fun String.component3() = this[2]

        fun part1(input: List<String>): Int {
            fun shapeScore(shape: Char) = (shape - 'X' + 1)

            fun resultScore(theirShape: Char, myShape: Char) =
                when (theirShape to myShape) {
                    'B' to 'X', 'C' to 'Y', 'A' to 'Z' -> SCORE_LOST
                    'A' to 'X', 'B' to 'Y', 'C' to 'Z' -> SCORE_DRAW
                    'C' to 'X', 'A' to 'Y', 'B' to 'Z' -> SCORE_WIN
                    else -> error("Check your inputs")
                }

            return input.sumOf { round ->
                val (theirShape, _, myShape) = round
                shapeScore(myShape) + resultScore(theirShape, myShape)
            }
        }

        fun part2(input: List<String>): Int {
            fun shapeScore(theirShape: Char, desiredResult: Char) =
                when (theirShape to desiredResult) {
                    'A' to 'Y', 'B' to 'X', 'C' to 'Z' -> 1
                    'B' to 'Y', 'C' to 'X', 'A' to 'Z' -> 2
                    'C' to 'Y', 'A' to 'X', 'B' to 'Z' -> SCORE_DRAW
                    else -> error("Check your inputs")
                }

            fun resultScore(result: Char) = (result - 'X') * SCORE_DRAW

            return input.sumOf { round ->
                val (theirScope, _, result) = round
                shapeScore(theirScope, result) + resultScore(result)
            }
        }
    }
}

fun main() {
    val input = readInput("Day02")
    println(Day02A.part1(input))
    println(Day02A.part2(input))
}
