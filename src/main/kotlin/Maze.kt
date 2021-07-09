import java.lang.StringBuilder

class Maze (
    val matrixValue: Int,
    matrixDefault: Int,
    entryX: Int, entryY:
    Int, goalX: Int,
    goalY: Int,
    paths: List<PathGen>,
    private val renderer: Renderer = defaultRenderer()
) {
    var matrix = Array(matrixValue) {IntArray(matrixValue){matrixDefault} }

    interface Renderer {
        fun render(maze: Maze) : String
    }

    class defaultRenderer : Renderer {
        override fun render(maze: Maze) : String {
            return StringBuilder().apply {
                for (i in 0 until maze.matrixValue) {
                    for (j in 0 until maze.matrixValue) {
                        append(maze.matrix[j][i].toString() + if (j<maze.matrixValue - 1)  " " else "")
                    }
                    if (i < maze.matrixValue - 1) {
                        append("\n")
                    }
                }
            }.toString()
        }
    }

    init {
        paths.forEach {
            it.generate(matrix, entryX, entryY)
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

    override fun toString() = renderer.render(this)
}

