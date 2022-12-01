import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class Day01Test {

    private val elvesCalories =
        listOf("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000")

    @Test
    fun generateElvesList_with_one_number_should_return_one_element() {
        generateElvesList(listOf("1")) shouldBe listOf(1)
    }

    @Test
    fun generateElvesList_with_two_numbers_should_return_sum_of_two_elements() {
        generateElvesList(listOf("1", "2")) shouldBe listOf(3)
    }

    @Test
    fun generateElvesList_with_two_number_blocks_should_return_two_sums() {
        generateElvesList(listOf("1", "2", "3", "", "4")) shouldBe listOf(6, 4)
    }

    @Test
    fun part1_should_return_69281() {
        part1(elvesCalories) shouldBe 24000
    }

    @Test
    fun part2_should_return_45000() {
        part2(elvesCalories) shouldBe 45000
    }
}
