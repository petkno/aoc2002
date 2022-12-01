fun main() {
    fun generateElvesList(input: List<String>): MutableList<Int> {
        val elves = mutableListOf<Int>(0)
        input.forEach {
            if (it.isBlank()) {
                elves.add(0)
            } else {
                elves[elves.lastIndex] += it.toInt()
            }
        }
        return elves
    }

    fun part1(input: List<String>)= generateElvesList(input).max()

    fun part2(input: List<String>)= generateElvesList(input).sortedDescending().take(3).sum()

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

