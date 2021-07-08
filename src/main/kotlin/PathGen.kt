interface PathGen {
    fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int)
}

class NullPathGen : PathGen {
    override fun generate(maze: Array<IntArray>, entryX: Int, entryY: Int) {
        // Purposefully do nothing
        return
    }
}