import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day04Test : FreeSpec({
    "part1" - {
        listOf(
            listOf("2-4, 6-8") to 0,
            listOf("2-3, 4-5") to 0,
            listOf("5-7, 7-9") to 0,
            listOf("2-8, 3-7") to 1,
            listOf("6-6, 4-6") to 1,
            listOf("2-6, 4-8") to 0,
            listOf("2-4, 6-8", "2-3, 4-5", "5-7, 7-9", "2-8, 3-7", "6-6, 4-6", "2-6, 4-8") to 2
        ).forEach { (input: List<String>, result: Int) ->
            "is should play $input to $result" {
                Day04.part1(input) shouldBe result
            }
        }
    }

    "part2" - {
        listOf(
            listOf("2-4, 6-8") to 0,
            listOf("2-3, 4-5") to 0,
            listOf("5-7, 7-9") to 1,
            listOf("2-8, 3-7") to 1,
            listOf("6-6, 4-6") to 1,
            listOf("2-6, 4-8") to 1,
            listOf("2-4, 6-8", "2-3, 4-5", "5-7, 7-9", "2-8, 3-7", "6-6, 4-6", "2-6, 4-8") to 4
        ).forEach { (input: List<String>, result: Int) ->
            "is should play $input to $result" {
                Day04.part2(input) shouldBe result
            }
        }
    }
})
