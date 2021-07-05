class PathGenSpiral : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = entryX
        var b = entryY
        for(i in 0..maze.size/2) {
            maze[a][b] = 1
            a++
        }
        a = maze.size/2
        for(i in 0..maze.size/2) {
            maze[a][b] = 1
            b++
        }
        for(i in a until maze.size) {
            maze[a][b] = 1
            a++
        }
    }
}