class ASCIIRenderer : Maze.Renderer {
    val PURPLE_BACKGROUND = "\u001b[45m"
    val GREEN_BACKGROUND = "\u001b[42m" // GREEN
    val RESET = "\u001b[0m" // Text Reset

    override fun render(maze: Maze): String {
        return StringBuilder().apply {
            for (i in 0 until maze.matrixValue) {
                for (j in 0 until maze.matrixValue) {
                    when (maze.matrix[j][i]) {
                        0 -> append("$PURPLE_BACKGROUND $RESET")
                        1 -> append("$GREEN_BACKGROUND $RESET")
                        2 -> append("${GREEN_BACKGROUND}E$RESET")
                        3 -> append("${GREEN_BACKGROUND}G$RESET")

                    }
                }
                append ("\n")
            }
        }.toString()
    }
}