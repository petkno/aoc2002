import Day02.Results.*
import Day02.RockPaperScissors
import Day02.RockPaperScissors.*
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day02Test {
    @Test
    fun rock_score_is_1() {
        ROCK.score shouldBe 1
    }

    @Test
    fun paper_score_is_2() {
        PAPER.score shouldBe 2
    }

    @Test
    fun scissors_score_is_3() {
        SCISSORS.score shouldBe 3
    }

    @Test
    fun gameResultPoints_loss_is_0() {
        LOSS.points shouldBe 0
    }

    @Test
    fun gameResultPoints_draw_is_3() {
        DRAW.points shouldBe 3
    }

    @Test
    fun gameResultPoints_win_is_6() {
        WIN.points shouldBe 6
    }

    @Test
    fun rock_play() {
        ROCK.play(ROCK) shouldBe DRAW
        ROCK.play(SCISSORS) shouldBe WIN
        ROCK.play(PAPER) shouldBe LOSS
    }

    @Test
    fun scissors_play() {
        SCISSORS.play(SCISSORS) shouldBe DRAW
        SCISSORS.play(PAPER) shouldBe WIN
        SCISSORS.play(ROCK) shouldBe LOSS
    }

    @Test
    fun paper_play() {
        PAPER.play(PAPER) shouldBe DRAW
        PAPER.play(ROCK) shouldBe WIN
        PAPER.play(SCISSORS) shouldBe LOSS
    }

    @Test
    fun score() {
        PAPER.playScore(ROCK) shouldBe 8
        ROCK.playScore(PAPER) shouldBe 1
        SCISSORS.playScore(SCISSORS) shouldBe 6
    }

    @Test
    fun getBy_should_be_mapped() {
        RockPaperScissors.getBy("A") shouldBe ROCK
        RockPaperScissors.getBy("B") shouldBe PAPER
        RockPaperScissors.getBy("C") shouldBe SCISSORS
        RockPaperScissors.getBy("X") shouldBe ROCK
        RockPaperScissors.getBy("Y") shouldBe PAPER
        RockPaperScissors.getBy("Z") shouldBe SCISSORS
    }

    @Test
    fun part1() {
        Day02().part1(listOf("A Y")) shouldBe 8
        Day02().part1(listOf("B X")) shouldBe 1
        Day02().part1(listOf("C Z")) shouldBe 6
        Day02().part1(listOf("A Y", "B X", "C Z")) shouldBe 15
    }

    @Test
    fun rock_chooseForResult() {
        ROCK.chooseForResult(DRAW) shouldBe ROCK
        ROCK.chooseForResult(WIN) shouldBe PAPER
        ROCK.chooseForResult(LOSS) shouldBe SCISSORS
    }

    @Test
    fun paper_chooseForResult() {
        PAPER.chooseForResult(DRAW) shouldBe PAPER
        PAPER.chooseForResult(WIN) shouldBe SCISSORS
        PAPER.chooseForResult(LOSS) shouldBe ROCK
    }

    @Test
    fun scissors_chooseForResult() {
        SCISSORS.chooseForResult(DRAW) shouldBe SCISSORS
        SCISSORS.chooseForResult(WIN) shouldBe ROCK
        SCISSORS.chooseForResult(LOSS) shouldBe PAPER
    }

    @Test
    fun part2() {
        Day02().part2(listOf("A Y")) shouldBe 4
        Day02().part2(listOf("B X")) shouldBe 1
        Day02().part2(listOf("C Z")) shouldBe 7
        Day02().part2(listOf("A Y", "B X", "C Z")) shouldBe 12
    }
}
