class PathGenDeadEndLine : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        var a = entryX
        val b = maze.size - 2
        for(i in 0..maze.size/2){
            maze[a][b] = 1
            a++
        }
    }
}