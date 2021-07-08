object PathFactory {
    private var generator : List<()-> List<PathGen>> = listOf (
        {
            listOf(
                PathGenDeadEndLine(),
                PathGenVerticalLine(),
                PathGenSpiral(),
                PathGenHorizontalLine(),
                PathGenLShapeLine(),
                PathGenSquare()
            )
        },
        {
            listOf(
               NullPathGen()
            )
        }
    )

    fun generate(idx: Int) : List<PathGen> = generator[idx]()

    fun valid(idx: Int) = idx < generator.size && idx >= 0
}