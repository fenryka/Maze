import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MazeTest {
    val mazeSize = 10
    val entryX = 0
    val entryY = 0
    val goalX = 4
    val goalY = 4
    val matrixDefault = 0

    val deadEnd = PathGenDeadEndLine()
    val verticalLine = PathGenVerticalLine()
    val spiral = PathGenSpiral()
    val horizontalLine = PathGenHorizontalLine()
    val lShapeLine = PathGenLShapeLine()
    val square = PathGenSquare()

    @Test
    fun mazeSize() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val maze = Maze(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        assertEquals(mazeSize, maze.matrix.size)
    }

    @Test
    fun mazeToString() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val maze = Maze(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        println(maze)
    }

    @Test
    fun setMazeEntry() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val maze = Maze(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        assertEquals(2, maze.matrix[entryX][entryY])
        println(maze)
    }

    @Test
    fun setMazeGoal() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val maze = Maze(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        assertEquals(3, maze.matrix[goalX][goalY])
        println(maze)
    }
}

