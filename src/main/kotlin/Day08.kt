class Day08(private val lines: List<String>) {
    private val width = lines.first().length

    private var treeHeight = fillTreeHeight()
    private var treeVisible = Array(width) { BooleanArray(width) }
    private val treeScenicScore = Array(width) { IntArray(width) }

    private fun fillTreeHeight(): Array<IntArray> {
        val grid = Array(width) { IntArray(width) }
        lines.mapIndexed { row, line ->
            line.mapIndexed { column, c -> grid[row][column] = c.digitToInt() }
        }
        return grid
    }

    fun part1(): Int {
        scanVisibility()
        return treeVisible.sumOf { it.count { it } }
    }

    fun part2(): Int {
        calculateScenicScores()
        return treeScenicScore.maxOf { row -> row.maxOf { it } }
    }

    private fun calculateScenicScores() {
        treeHeight.forEachIndexed { rowNumber, row ->
            row.forEachIndexed { colNumber, height ->
                treeScenicScore[rowNumber][colNumber] = getScenicScoreUp(height, rowNumber, colNumber) *
                        getScenicScoreLeft(height, rowNumber, colNumber) *
                        getScenicScoreRight(height, rowNumber, colNumber) *
                        getScenicScoreDown(height, rowNumber, colNumber)
            }
        }
    }

    private fun scanVisibility() {
        var heights = treeHeight
        var visible = treeVisible
        repeat(4) {
            heights.forEachIndexed { rowNumber, row ->
                var maxHeight = 0
                row.forEachIndexed { colNumber, height ->
                    if (colNumber == 0 || height > maxHeight) {
                        visible[rowNumber][colNumber] = true
                        maxHeight = height
                    }
                }
            }
            heights = rotateClockwise(heights)
            visible = rotateClockwise(visible)
        }
        treeHeight = heights
        treeVisible = visible
    }

    private fun getScenicScoreLeft(height: Int, rowNumber: Int, colNumber: Int) =
        getScenicScoreHorizontal(height, rowNumber, colNumber, -1)

    private fun getScenicScoreRight(height: Int, rowNumber: Int, colNumber: Int) =
        getScenicScoreHorizontal(height, rowNumber, colNumber, 1)

    private fun getScenicScoreHorizontal(height: Int, rowNumber: Int, colNumber: Int, direction: Int): Int {
        val nextColIndex = colNumber + direction
        return when {
            nextColIndex !in 0..treeHeight.first().lastIndex -> 0
            treeHeight[rowNumber][nextColIndex] >= height -> 1
            else -> 1 + getScenicScoreHorizontal(height, rowNumber, nextColIndex, direction)
        }
    }

    private fun getScenicScoreUp(height: Int, rowNumber: Int, colNumber: Int) =
        getScenicScoreVertical(height, rowNumber, colNumber, -1)

    private fun getScenicScoreDown(height: Int, rowNumber: Int, colNumber: Int) =
        getScenicScoreVertical(height, rowNumber, colNumber, 1)

    private fun getScenicScoreVertical(height: Int, rowNumber: Int, colNumber: Int, direction: Int): Int {
        val nextRowIndex = rowNumber + direction
        return when {
            nextRowIndex !in 0..treeHeight.lastIndex -> 0
            treeHeight[nextRowIndex][colNumber] >= height -> 1
            else -> 1 + getScenicScoreVertical(height, nextRowIndex, colNumber, direction)
        }
    }

    private fun rotateClockwise(matrix: Array<IntArray>): Array<IntArray> {
        val transpose = Array(matrix.first().size) { IntArray(matrix.size) }
        matrix.forEachIndexed { i, row -> row.forEachIndexed { j, col -> transpose[j][matrix.size - 1 - i] = col } }

        return transpose
    }

    private fun rotateClockwise(matrix: Array<BooleanArray>): Array<BooleanArray> {
        val transpose = Array(matrix.first().size) { BooleanArray(matrix.size) }
        matrix.forEachIndexed { i, row -> row.forEachIndexed { j, col -> transpose[j][matrix.size - 1 - i] = col } }

        return transpose
    }
}

fun main() {
    println(Day08(readInput("Day08")).part1())
    println(Day08(readInput("Day08")).part2())
}
