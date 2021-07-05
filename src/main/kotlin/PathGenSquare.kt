class PathGenSquare : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = entryX + 2
        var b = maze.size/2
        for(i in 0..maze.size/3) {
            maze[a][b] = 1
            a++
        }
        for (i in 0 ..maze.size/3) {
            maze[a][b] = 1
            b--
        }
        for (i in 0 ..maze.size/3) {
            maze[a][b] = 1
            a--
        }
        for (i in 0 ..maze.size/3) {
            maze[a][b] = 1
            b++
        }
    }
}