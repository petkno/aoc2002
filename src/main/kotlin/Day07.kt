class Day07(lines: List<String>) {
    private val sizes = buildMap {
        put("", 0)
        var currentDir = ""
        for (line in lines) {
            if (line.startsWith("$ cd ")) {
                val dir = line.substringAfterLast(" ")
                currentDir = when (dir) {
                    "/" -> ""
                    ".." -> currentDir.substringBeforeLast('/', "")
                    else -> if (currentDir.isEmpty()) dir else "$currentDir/$dir"
                }
            }
            if (line.matches("""\d+.*""".toRegex())) {
                val size = line.substringBefore(" ").toInt()
                var dir = currentDir
                while (true) {
                    put(dir, getOrElse(dir) { 0 } + size)
                    if (dir.isEmpty()) break
                    dir = dir.substringBeforeLast('/', "")
                }
            }
        }
    }

    fun part1() = sizes.values.sumOf { if (it <= 100000) it else 0 }

    fun part2(): Int {
        val totalSize = sizes.getOrDefault("", 0)

        return sizes.values.asSequence().filter { 70000000 - (totalSize - it) >= 30000000 }.min()
    }
}

fun main() {
    println(Day07(readInput("Day07")).part1())
    println(Day07(readInput("Day07")).part2())
}
