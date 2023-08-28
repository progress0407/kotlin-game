class Number(
    private val index: Int,
    private val value: Int
) {

    fun compare(other: Number): MatchResult =
        when {
            strikeCase(other) -> MatchResult.STRIKE
            ballCase(other) -> MatchResult.BALL
            else -> MatchResult.NOTHING
        }

    private fun strikeCase(other: Number) = this == other

    private fun ballCase(other: Number) = this.value == other.value && this.index != other.index

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (index != other.index) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = index
        result = 31 * result + value
        return result
    }
}