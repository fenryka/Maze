class PathGenHorizontalLine : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = entryX
        val b = maze.size -5
        for(i in maze) {
            maze[a][b] = 1
            a++
        }
    }
}