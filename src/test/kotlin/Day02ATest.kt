import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day02ATest : FreeSpec({
    "part1" - {
        listOf(
            listOf("A Y") to 8,
            listOf("B X") to 1,
            listOf("C Z") to 6,
            listOf("A Y", "B X", "C Z") to 15
        ).forEach { (input: List<String>, result: Int) ->
            "it should play $input to $result" {
                Day02A.part1(input) shouldBe result
            }
        }
    }

    "part2" - {
        listOf(
            listOf("A Y") to 4,
            listOf("B X") to 1,
            listOf("C Z") to 7,
            listOf("A Y", "B X", "C Z") to 12
        ).forEach { (input: List<String>, result: Int) ->
            "it should play $input to $result" {
                Day02A.part2(input) shouldBe result
            }
        }
    }
})
