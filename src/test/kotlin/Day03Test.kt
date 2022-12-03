import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

private const val LINE1 = "vJrwpWtwJgWrhcsFMMfFFhFp"
private const val LINE2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
private const val LINE3 = "PmmdzqPrVvPwwTWBwg"
private const val LINE4 = "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
private const val LINE5 = "ttgJtRGJQctTZtZT"
private const val LINE6 = "CrZsJsPPZsGzwwsLwLmpwMDw"

class Day03Test {

    @Test
    fun split() {
        Day03().split("ab") shouldBe Pair("a", "b")
        Day03().split(LINE1) shouldBe Pair("vJrwpWtwJgWr", "hcsFMMfFFhFp")
        Day03().split(LINE2) shouldBe Pair("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL")
        Day03().split(LINE3) shouldBe Pair("PmmdzqPrV", "vPwwTWBwg")
    }

    @Test
    fun aAppearsInBoth_without_matching_should_return_empty_list() {
        Day03().appearsInBoth("a", "b") shouldBe ""
    }

    @Test
    fun appearsInBoth_with_single_matching_should_return_single_char() {
        Day03().appearsInBoth("a", "a") shouldBe "a"
    }

    @Test
    fun appearsInBoth_with_single_matching_in_a_long_string_should_return_single_char() {
        Day03().appearsInBoth("abc", "dcf") shouldBe "c"
    }

    @Test
    fun calculatePriority_with_one_char() {
        Day03().calculatePriority("p") shouldBe 16
    }

    @Test
    fun part1() {
        Day03().part1(listOf(LINE1)) shouldBe 16
        Day03().part1(listOf(LINE2)) shouldBe 38
        Day03().part1(listOf(LINE3)) shouldBe 42
        Day03().part1(listOf(LINE4)) shouldBe 22
        Day03().part1(listOf(LINE5)) shouldBe 20
        Day03().part1(listOf(LINE6)) shouldBe 19

        Day03().part1(listOf(LINE1, LINE2, LINE3, LINE4, LINE5, LINE6)) shouldBe 157
    }

    @Test
    fun part2() {
        Day03().part2(listOf(LINE1, LINE2, LINE3)) shouldBe 18
        Day03().part2(listOf(LINE4, LINE5, LINE6)) shouldBe 52

        Day03().part2(listOf(LINE1, LINE2, LINE3, LINE4, LINE5, LINE6)) shouldBe 70
    }
}