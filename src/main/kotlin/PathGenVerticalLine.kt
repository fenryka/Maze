class PathGenVerticalLine : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = entryX
        var b = entryY
        for(i in maze) {
            maze[a][b] = 1
            b++
        }
    }
}