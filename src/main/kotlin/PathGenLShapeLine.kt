class PathGenLShapeLine : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = maze.size/3
        var b = maze.size - 1
        for(i in 0..maze.size - 3) {
            maze[a][b] = 1
            b--
        }
        b = 2
        for(i in 0..maze.size/2) {
            maze[a][b] = 1
            a++
        }
    }
}