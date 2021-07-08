import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertIs

internal class GameTest {
    val mazeSize = 10
    val entryX = 0
    val entryY = 0
    var goalX = 2
    var goalY = 2
    var matrixDefault = 0

    val deadEnd = PathGenDeadEndLine()
    val verticalLine = PathGenVerticalLine()
    val spiral = PathGenSpiral()
    val horizontalLine = PathGenHorizontalLine()
    val lShapeLine = PathGenLShapeLine()
    val square = PathGenSquare()

    @Test
    fun playerLocationTest() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        assertEquals(game.locationX, entryX)
        assertEquals(game.locationY, entryY)
    }

    @Test
    fun upYesTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.up())
    }

    @Test
    fun upNoTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.up())
    }

    @Test
    fun downYesTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.down())
    }

    @Test
    fun downNoTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.down())
    }

    @Test
    fun rightYesTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.right())
    }

    @Test
    fun rightNoTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.right())
    }

    @Test
    fun leftYesTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.left())
    }

    @Test
    fun leftNoTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.left())
    }

    //stack order:  1)left 2)right 3)down 4)up

    @Test
    fun checkEdgeYEdgeTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = mazeSize - 1
        game.pushChildren()
        game.checkEdge()
        assertTrue(game.dfs.size == 3)
        assertEquals(Pair(0, mazeSize - 1), game.dfs.first()) //left
        assertEquals(Pair(2, mazeSize - 1), game.dfs[1]) //right #down elim
        assertEquals(Pair(1, mazeSize - 2), game.dfs.last()) //up
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs.last())
    }

    @Test
    fun checkEdgeXEdgeTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = mazeSize - 1
        game.locationY = 1
        game.pushChildren()
        game.checkEdge()
        assertTrue(game.dfs.size == 3)
        assertEquals(Pair(mazeSize - 2, 1), game.dfs.first()) //left #right elim
        assertEquals(Pair(mazeSize - 1, 2), game.dfs[1]) //down
        assertEquals(Pair(mazeSize - 1, 0), game.dfs.last()) //up
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs.last())
    }

    @Test
    fun checkEdgeY0Test() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 0
        game.pushChildren()
        game.checkEdge()
        assertTrue(game.dfs.size == 3)
        assertEquals(Pair(0, 0), game.dfs.first()) //left
        assertEquals(Pair(2, 0), game.dfs[1]) //right
        assertEquals(Pair(1, 1), game.dfs.last()) //down #up elim
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs.last())
    }

    @Test
    fun checkEdgeX0Test() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 0
        game.locationY = 1
        game.pushChildren()
        game.checkEdge()
        assertTrue(game.dfs.size == 3)
        assertEquals(Pair(1, 1), game.dfs.first()) //#left elim, right
        assertEquals(Pair(0, 2), game.dfs[1]) //down
        assertEquals(Pair(0, 0), game.dfs.last()) //up
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs.last())
    }

    @Test
    fun checkEdgeTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.pushChildren()
        game.checkEdge()
        assertTrue(game.dfs.size == 4)
        assertEquals(Pair(0, 1), game.dfs.first()) //left
        assertEquals(Pair(2, 1), game.dfs[1]) //right
        assertEquals(Pair(1, 2), game.dfs[2]) //down
        assertEquals(Pair(1, 0), game.dfs.last()) //up
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs[2])
        println(game.dfs.last())
    }

    @Test
    fun removeUpTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(1,0))
        game.removeUp()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addUpTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.addUp()
        assertEquals(Pair(1, 0), game.dfs.first())
    }

    @Test
    fun removeDownTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(1,2))
        game.removeDown()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addDownTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.addDown()
        assertEquals(Pair(1, 2), game.dfs.first())
    }

    @Test
    fun removeRightTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(2,1))
        game.removeRight()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addRightTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.addRight()
        assertEquals(Pair(2, 1), game.dfs.first())
    }

    @Test
    fun removeLeftTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(0,1))
        game.removeLeft()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addLeftTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.addLeft()
        assertEquals(Pair(0, 1), game.dfs.first())
    }

    @Test
    fun popHeadTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.pushChildren()
        assertTrue(game.dfs.size == 4)
        val x = game.dfs.first().first
        val y = game.dfs.first().second
        val nextHeadValue = game.dfs[1]
        game.popHead()
        assertTrue(game.locationX == x)
        assertTrue(game.locationY == y)
        assertTrue(game.dfs.size == 3)
        assertTrue(game.dfs.first() == nextHeadValue)
    }

    @Test
    fun pushChildrenTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.pushChildren()
        assertTrue(game.dfs.size == 4)
        assertEquals(Pair(0, 1), game.dfs.first()) //left
        assertEquals(Pair(2, 1), game.dfs[1]) //right
        assertEquals(Pair(1, 2), game.dfs[2]) //down
        assertEquals(Pair(1, 0), game.dfs.last()) //up
        println(game.dfs.first())
        println(game.dfs[1])
        println(game.dfs[2])
        println(game.dfs.last())
    }

    @Test
    fun checkGoalStateTest() {
        goalX = 5
        goalY = 5
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 5
        game.locationY = 5
        assertTrue(game.checkGoalState())
    }

    @Test
    fun goForwardTest() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.pushChildren()
        assertTrue(game.dfs.size == 4)
        assertEquals(Pair(0, 1), game.dfs.first()) //left
        assertEquals(Pair(2, 1), game.dfs[1]) //right
        assertEquals(Pair(1, 2), game.dfs[2]) //down
        assertEquals(Pair(1, 0), game.dfs.last()) //up

        game.alreadyVisited.addFirst(Pair(0, 1))
        game.goForward()

        assertEquals(Pair(2, 1), game.dfs.first()) //new first
        assertEquals(Pair(1, 2), game.dfs[1])
        assertEquals(Pair(1, 0), game.dfs[2])
        assertEquals(Pair(0, 1), game.dfs.last()) //old first
    }

    @Test
    fun addStartingArea() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        assertTrue(game.alreadyVisited.contains(Pair(entryX, entryY)))
    }

    @Test
    fun checkHedge() {
        val paths = ArrayList<PathGen>()
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 2
        game.locationY = 1
        game.maze.matrix[2][0] = 1
        game.maze.matrix[3][1] = 1
        game.maze.matrix[2][2] = 1
        game.maze.matrix[1][1] = 0
        game.pushChildren()
        assertTrue(game.dfs.size == 4)
        assertEquals(Pair(1, 1), game.dfs.first()) //left
        assertEquals(Pair(3, 1), game.dfs[1]) //right
        assertEquals(Pair(2, 2), game.dfs[2]) //down
        assertEquals(Pair(2, 0), game.dfs.last()) //up
        game.checkHedge()
        assertTrue(game.dfs.size == 3)
        assertEquals(Pair(3, 1), game.dfs.first())
        assertEquals(Pair(2, 2), game.dfs[1])
        assertEquals(Pair(2, 0), game.dfs.last())
    }

    @Test
    fun solveMazeDFSTest_Easy() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.solveMazeDFS()
        println(game.maze)
        println(game.solveMazeDFS())
    }

    @Test
    fun solveMazeDFSTest_Harder() {
        val paths = ArrayList<PathGen>()
        paths.add(deadEnd)
        paths.add(verticalLine)
        paths.add(spiral)
        paths.add(horizontalLine)
        paths.add(lShapeLine)
        paths.add(square)
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)

        game.solveMazeDFS()
        println(game.maze)
        println(game.solveMazeDFS())
    }

}