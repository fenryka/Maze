import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertIs

internal class GameTest {
    val mazeSize = 10
    val entryX = 0
    val entryY = 0
    val goalX = 4
    val goalY = 4
    var matrixDefault = 0

    val deadEnd = PathGenDeadEndLine()
    val verticalLine = PathGenVerticalLine()
    val spiral = PathGenSpiral()
    val horizontalLine = PathGenHorizontalLine()
    val lShapeLine = PathGenLShapeLine()
    val square = PathGenSquare()

    @Test
    fun playerLocation() {
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
    fun upYes() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.up())
    }

    @Test
    fun upNo() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.up())
    }

    @Test
    fun downYes() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.down())
    }

    @Test
    fun downNo() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.down())
    }

    @Test
    fun rightYes() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.right())
    }

    @Test
    fun rightNo() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.right())
    }

    @Test
    fun leftYes() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertTrue(game.left())
    }

    @Test
    fun leftNo() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 0
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        assertFalse(game.left())
    }

    @Test
    fun checkEdge() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1


    }

    @Test
    fun removeUp() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(1,0))
        game.removeUp()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addUp() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.addUp()
        assertEquals(Pair(1, 0), game.dfs.first())
    }

    @Test
    fun removeDown() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(1,2))
        game.removeDown()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addDown() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.addDown()
        assertEquals(Pair(1, 2), game.dfs.first())
    }

    @Test
    fun removeRight() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(2,1))
        game.removeRight()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addRight() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.addRight()
        assertEquals(Pair(2, 1), game.dfs.first())
    }

    @Test
    fun removeLeft() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        val dfs = ArrayDeque<Pair<Int, Int>>()
        game.locationX = 1
        game.locationY = 1
        game.dfs.addFirst(Pair(0,1))
        game.removeLeft()
        assertTrue(game.dfs.isEmpty())
    }

    @Test
    fun addLeft() {
        val paths = ArrayList<PathGen>()
        matrixDefault = 1
        val game = Game(mazeSize, matrixDefault, entryX, entryY, goalX, goalY, paths)
        game.locationX = 1
        game.locationY = 1
        game.addLeft()
        assertEquals(Pair(0, 1), game.dfs.first())
    }

}