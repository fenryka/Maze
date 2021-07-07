fun main() {
    val paths = ArrayList<PathGen>()
    val deadEnd = PathGenDeadEndLine()
    val verticalLine = PathGenVerticalLine()
    val spiral = PathGenSpiral()
    val horizontalLine = PathGenHorizontalLine()
    val lShapeLine = PathGenLShapeLine()
    val square = PathGenSquare()
    paths.add(deadEnd)
    paths.add(verticalLine)
    paths.add(spiral)
    paths.add(horizontalLine)
    paths.add(lShapeLine)
    paths.add(square)

    val game = Game(20, 0, 0, 0, 0, 9, paths)
    println(game.maze)
}

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            main()
        }
    }
}