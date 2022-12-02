
class Day02 {
    enum class RockPaperScissors(val score: Int) {
        ROCK(1) {
            override fun play(opponent: RockPaperScissors): Results = when (opponent) {
                ROCK -> Results.DRAW
                SCISSORS -> Results.WIN
                PAPER -> Results.LOSS
            }

            override fun chooseForResult(result: Results): RockPaperScissors = when (result) {
                Results.DRAW -> this
                Results.WIN -> PAPER
                Results.LOSS -> SCISSORS
            }
        },
        PAPER(2) {
            override fun play(opponent: RockPaperScissors): Results = when (opponent) {
                PAPER -> Results.DRAW
                ROCK -> Results.WIN
                SCISSORS -> Results.LOSS
            }

            override fun chooseForResult(result: Results): RockPaperScissors = when (result) {
                Results.DRAW -> this
                Results.WIN -> SCISSORS
                Results.LOSS -> ROCK
            }
        },
        SCISSORS(3) {
            override fun play(opponent: RockPaperScissors): Results = when (opponent) {
                SCISSORS -> Results.DRAW
                PAPER -> Results.WIN
                ROCK -> Results.LOSS
            }

            override fun chooseForResult(result: Results): RockPaperScissors = when (result) {
                Results.DRAW -> this
                Results.WIN -> ROCK
                Results.LOSS -> PAPER
            }
        };


        abstract fun play(opponent: RockPaperScissors): Results
        abstract fun chooseForResult(result: Results): RockPaperScissors

        fun playScore(opponent: RockPaperScissors) = this.score + play(opponent).points

        companion object {
            fun getBy(value: String) = when (value) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> throw IllegalArgumentException("unknown value: $value")
            }
        }
    }

    enum class Results(val points: Int) {
        LOSS(0), DRAW(3), WIN(6);

        companion object {
            fun byPlayresult(value: String) = when (value) {
                "X" -> LOSS
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException("unknown value: $value")
            }
        }
    }

    fun part1(input: List<String>) =
        input.sumOf {
            val play = it.split(" ")
            val opponent = RockPaperScissors.getBy(play.first())
            val hand = RockPaperScissors.getBy(play.last())

            hand.playScore(opponent)
        }


    fun part2(input: List<String>) =
        input.sumOf {
            val play = it.split(" ")
            val opponent = RockPaperScissors.getBy(play.first())
            val results = Results.byPlayresult(play.last())
            val hand = opponent.chooseForResult(results)

            hand.playScore(opponent)
        }
}

fun main() {
    val input = readInput("Day02")
    println(Day02().part1(input))
    println(Day02().part2(input))
}
