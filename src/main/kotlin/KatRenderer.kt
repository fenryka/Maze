class KatRenderer : Maze.Renderer {

    override fun render(maze: Maze): String {

        return StringBuilder().apply {
            for (i in 0 until maze.matrixValue) {
                for (j in 0 until maze.matrixValue) {
                    when (maze.matrix[j][i]) {
                        0 -> append ("■")
                        1 -> append ("□")
                        2 -> append ("◀")
                        3 -> append ("◁")
                    }
                }

                append("\n")
            }
        }.toString()

    }
}