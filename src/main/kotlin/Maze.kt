import java.lang.StringBuilder

class Maze (val matrixValue: Int, entryX: Int, entryY: Int, goalX: Int, goalY: Int) {
    val matrix = Array(matrixValue) {IntArray(matrixValue){0} }

    fun setMazeGoal(goalX: Int, goalY: Int) {
        matrix[goalX][goalY] = 3
    }

    fun setMazeEntry(entryX: Int, entryY: Int) {
        matrix[entryX][entryY] = 1
    }

    fun setMazePath() {

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