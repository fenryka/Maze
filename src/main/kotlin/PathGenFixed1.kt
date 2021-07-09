class PathGenFixed1 : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        for (x in 0..5) {
            maze[x][10] = 1
        }

        maze[5][11] = 1
        maze[5][12] = 1

        for (x in 6..12) {
            maze[x][10] = 1
            maze[x][12] = 1
        }

        maze[12][11] = 1

        for (x in 13..19) {
            maze[x][10] = 1
        }

    }
}