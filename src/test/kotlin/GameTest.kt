import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

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

}