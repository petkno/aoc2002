import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class Day09Test : FreeSpec({
    "part1" - {
        listOf(
            listOf("R 1") to 1,
            listOf("R 4") to 4,
            listOf("R 4", "U 1") to 4,
            listOf("R 4", "U 4") to 7,
            listOf("R 4", "U 4", "L 3") to 9,
            listOf("R 4", "U 4", "L 3", "D 1") to 9,
            listOf("R 4", "U 4", "L 3", "D 1", "R 4", "D 1", "L 5", "R 2") to 13,
        ).forEach { (motions: List<String>, result: Int) ->
            "is play $motions should to $result" {
                Day09(motions).part1() shouldBe result
            }
        }
    }

    "part2" - {
        listOf(
            listOf("R 5") to 1,
            listOf("R 5", "U 8") to 1,
            listOf("R 5", "U 8", "L 8", "D 3", "R 17", "D 10", "L 25", "U 20") to 36,
        ).forEach { (motions: List<String>, result: Int) ->
            "is play $motions should to $result" {
                Day09(motions).part2() shouldBe result
            }
        }
    }
})
