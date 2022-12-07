import java.util.Stack

class Day05(val input: List<String>) {
    data class Move(val quantity: Int, val source: Int, val target: Int) {
        companion object {
            fun of(move: String) = move
                .split(" ")
                .filterIndexed { index, _ -> index % 2 == 1 }
                .map { it.toInt() }
                .let { Move(it[0], it[1] - 1, it[2] - 1) }
        }
    }

    private val numberOfStacks = input
        .dropWhile { it.contains("[") }
        .first()
        .split(" ")
        .filter { it.isNotBlank() }
        .maxOf { it.toInt() }

    private val stacks: List<Stack<Char>> = fillStacks()

    private val moves = getMoves()

    private fun getMoves(): MutableList<Move> {
        val moves = mutableListOf<Move>()
        input.filter { it.contains("move") }.map { moves.add(Move.of(it)) }
        return moves
    }

    private fun fillStacks(): List<Stack<Char>> {
        val stacks = List(numberOfStacks) { Stack<Char>() }
        input
            .filter { it.contains("[") }
            .map { line ->
                line.mapIndexed { index, char ->
                    if (char.isLetter()) {
                        val stackNumber = index / 4
                        val value = line[index]

                        stacks[stackNumber].add(0, value)
                    }
                }
            }

        return stacks
    }

    fun part1(): String {
        moves.map { move ->
            repeat(move.quantity) {
                stacks[move.target].push(stacks[move.source].pop())
            }
        }

        return stacks
            .map { stack -> stack.peek() }
            .joinToString(separator = "")
    }

    fun part2() : String {
        moves.map { move ->
            val tmpStack = Stack<Char>()
            repeat(move.quantity) {
                tmpStack.push(stacks[move.source].pop())
            }
            repeat(tmpStack.size) {
                stacks[move.target].push(tmpStack.pop())
            }
        }

        return stacks
            .map { stack -> stack.peek() }
            .joinToString(separator = "")
    }
}

fun main() {
    println(Day05(readInput("Day05")).part1())
    println(Day05(readInput("Day05")).part2())
}
