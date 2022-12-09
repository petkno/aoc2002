import java.awt.Point
import kotlin.math.abs

class Day09(private val motions: List<String>) {

    private val directionX = mapOf("L" to -1, "R" to 1)
    private val directionY = mapOf("U" to 1, "D" to -1)

    fun part1(): Int {
        var h = Point(0, 0)
        var t = Point(0, 0)
        val tpos = mutableSetOf<Point>()
        motions.forEach { motion ->
            val (direction, steps) = motion.split(" ")

            repeat(steps.toInt()) {
                val hTemp = h
                h = Point(h.x + directionX.getOrDefault(direction, 0), h.y + directionY.getOrDefault(direction, 0))
                if (abs(h.x - t.x) > 1 || abs(h.y - t.y) > 1) t = hTemp
                tpos.add(t)
            }
        }

        return tpos.size
    }

    fun part2() = 0
}

fun main() {
    println(Day09(readInput("Day09")).part1())
    println(Day09(readInput("Day09")).part2())
}
