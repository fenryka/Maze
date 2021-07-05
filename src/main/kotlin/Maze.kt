import java.lang.StringBuilder
class Maze (val matrixValue: Int, matrixDefault: Int, entryX: Int, entryY: Int, goalX: Int, goalY: Int, paths: List<PathGen>) {
    var matrix = Array(matrixValue) {IntArray(matrixValue){matrixDefault} }

    init {
        for(i in paths) {
            i.generate(matrix, entryX, entryY)
        }
        setMazeEntry(entryX, entryY)
        setMazeGoal(goalX, goalY)
    }

    fun setMazeGoal(goalX: Int, goalY: Int) {
        matrix[goalX][goalY] = 3
    }

    fun setMazeEntry(entryX: Int, entryY: Int) {
        matrix[entryX][entryY] = 2
    }

    override fun toString() = StringBuilder().apply {
        for (i in 0 until matrixValue) {
            for (j in 0 until matrixValue) {
                append(matrix[j][i].toString() + if (j<matrixValue - 1)  " " else "")
            }
            if (i < matrixValue - 1) {
                append("\n")
            }
        }
    }.toString()
}

