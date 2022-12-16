class Day10(lines: List<String>) {
    private val instructions = lines.map { it.toInstruction() }

    private val cycleSteps = listOf(20, 60, 100, 140, 180, 220)

    fun part1(): Int {
        var registerValue = 1
        var lastRegisterValue = registerValue
        var cycle = 0

        val instructionIterator = instructions.iterator()

        return cycleSteps.sumOf { cycleStep ->
            while (cycle < cycleStep) {
                lastRegisterValue = registerValue

                val instruction = instructionIterator.next()
                cycle += instruction.cycleSize
                if (instruction is Addx) registerValue += instruction.dx
            }
            cycleStep * lastRegisterValue
        }
    }

    fun part2(): Int {
        return 0
    }

    private interface Instruction {
        val cycleSize: Int
    }

    private class Noop : Instruction {
        override val cycleSize = 1
    }

    private class Addx(val dx: Int) : Instruction {
        override val cycleSize = 2
    }

    private fun String.toInstruction(): Instruction = when {
        this == "noop" -> Noop()
        else -> Addx(removePrefix("addx ").toInt())
    }
}

fun main() {
    println(Day10(readInput("Day10")).part1())
    println(Day10(readInput("Day10Test")).part2())
}
