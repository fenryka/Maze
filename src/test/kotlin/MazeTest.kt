import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MazeTest {
    val mazeSize = 10
    val entryX = 0
    val entryY = 0
    val goalX = 4
    val goalY = 4
    val mazeDefault = 0
    val maze = Maze(mazeSize, entryX, entryY, goalX, goalY)


    @Test
    fun mazeSize() {
        assertEquals(mazeSize, maze.matrix.size)
    }

    @Test
    fun mazeContent() {
        for(array in maze.matrix) {
            for(value in array) {
                assertEquals(mazeDefault, value)
            }
        }
    }

    @Test
    fun mazeToString() {
        println(maze)
    }

    @Test
    fun setMazeEntry() {
        maze.setMazeEntry(entryX, entryY)
        assertEquals(1, maze.matrix[entryX][entryY])
        println(maze)
    }

    @Test
    fun setMazePath() {
        maze.setMazePath()
        assertEquals()
        println(maze)
    }

    @Test
    fun setMazeGoal() {
        maze.setMazeGoal(goalX, goalY)
        assertEquals(3, maze.matrix[goalX][goalY])
        println(maze)
    }


}

