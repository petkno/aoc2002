import kotlin.math.abs

class Day15(lines: List<String>) {
    private val sensorsAndBeacons = lines.map { it.toSensorAndBeacons() }

    fun part1(y: Int = 2_000_000): Int {
        val intervals = mutableListOf<Pair<Int, Int>>()
        val allowsX = mutableListOf<Int>()
        for ((sensor, beacons) in sensorsAndBeacons) {
            val dist = dist(sensor, beacons)
            val dx = dist - abs(sensor.second - y)
            if (beacons.second == y) allowsX.add(beacons.first)
            if (dx <= 0) continue
            intervals.add(sensor.first - dx to sensor.first + dx)
        }

        val minX = intervals.map { it.first }.min()
        val maxX = intervals.map { it.second }.max()

        var ans = 0
        for (x in minX..maxX + 1) {
            if (x in allowsX) continue

            for ((left, right) in intervals) {
                if ((left <= x) and (x <= right)) {
                    ans++
                    break
                }
            }
        }
        return ans
    }

    private fun dist(left: Pair<Int, Int>, right: Pair<Int, Int>) =
        abs(left.first - right.first) + abs(left.second - right.second)

    private fun String.toSensorAndBeacons(): Pair<Pair<Int, Int>, Pair<Int, Int>> {
        val sx = this.substring(this.indexOf("x=") + 2, this.indexOf(',')).toInt()
        val sy = this.substring(this.indexOf("y=") + 2, this.indexOf(':')).toInt()
        val bx = this.substring(this.lastIndexOf("x=") + 2, this.lastIndexOf(',')).toInt()
        val by = this.substring(this.lastIndexOf("y=") + 2).toInt()
        return sx to sy to (bx to by)
    }
}

fun main() {
    println(Day15(readInput("Day15")).part1())
}
