object PathFactory {
    private var generator : List<Pair<String, ()-> List<PathGen>>> = listOf (
        Pair ("Curated 01") {
            listOf(
                PathGenDeadEndLine(),
                PathGenVerticalLine(),
                PathGenSpiral(),
                PathGenHorizontalLine(),
                PathGenLShapeLine(),
                PathGenSquare()
            )
        },
        Pair ("Random") {
            listOf(
                PathGenRandom1()
            )
        },
        Pair ("Fixed") {
            listOf(
                PathGenFixed1()
            )
        },
       Pair ("Null") {
           listOf(
               NullPathGen()
           )
       }
    )

    fun generate(idx: Int) : List<PathGen> = generator[idx].second()

    fun valid(idx: Int) = idx < generator.size && idx >= 0
}