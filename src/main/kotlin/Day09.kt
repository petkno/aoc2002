import java.awt.Point
import kotlin.math.absoluteValue
import kotlin.math.sign

class Day09(private val motions: List<String>) {

    private val directionX = mapOf("L" to -1, "R" to 1)
    private val directionY = mapOf("U" to 1, "D" to -1)

    fun part1() = calculateTailVisitPositions(1)

    fun part2() = calculateTailVisitPositions(9)

    private fun calculateTailVisitPositions(ropeLength: Int): Int {
        var h = Point(0, 0)
        val ts = MutableList(ropeLength) { Point(0, 0) }
        val tpos = mutableSetOf<Point>()
        motions.forEach { motion ->
            val (direction, steps) = motion.split(" ")

            repeat(steps.toInt()) {
                h = Point(h.x + directionX.getOrDefault(direction, 0), h.y + directionY.getOrDefault(direction, 0))
                ts.forEachIndexed { index, t ->
                    when (index) {
                        0 -> t.location = follow(h, t)
                        else -> t.location = follow(ts[index - 1], t)
                    }
                }
                tpos.add(ts.last())
            }
        }
        return tpos.size
    }

    private fun follow(head: Point, tail: Point): Point {
        val dX = head.x - tail.x
        val dY = head.y - tail.y
        if (dX.absoluteValue <= 1 && dY.absoluteValue <= 1) return tail
        val tailX = if (dX.absoluteValue >= dY.absoluteValue) head.x - dX.sign else head.x
        val tailY = if (dX.absoluteValue <= dY.absoluteValue) head.y - dY.sign else head.y
        return Point(tailX, tailY)
    }
}


fun main() {
    println(Day09(readInput("Day09")).part1())
    println(Day09(readInput("Day09")).part2())
}
