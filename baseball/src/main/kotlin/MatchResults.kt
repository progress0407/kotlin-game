import MatchResult.BALL
import MatchResult.STRIKE

data class MatchResults(private val matchResultCollection: List<MatchResult>) {

    val values: Map<MatchResult, Int>

    init {
        val hashMap = HashMap<MatchResult, Int>()
        hashMap[BALL] = 0
        hashMap[STRIKE] = 0
        for (value in matchResultCollection) {
            var count = hashMap[value] ?: 0
            hashMap[value] = ++count
        }
        values = hashMap
    }

    fun ballCase() = values[BALL]!! > 0 && values[STRIKE]!! == 0

    fun strikeCase() = values[BALL]!! == 0 && values[STRIKE]!! > 0

    fun ballAndStrikeCase() = values[BALL]!! > 0 && values[STRIKE]!! > 0

    fun nothingCase() = values[BALL]!! == 0 && values[STRIKE]!! == 0

    val ball get() = values[BALL]!!

    val strike get() = values[STRIKE]!!
}