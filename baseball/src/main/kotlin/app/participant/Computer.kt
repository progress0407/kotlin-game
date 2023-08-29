package app.participant

import app.BallNumber
import app.MatchResult
import app.MatchResults

class Computer(ballNumbers: List<BallNumber>) : Participant(ballNumbers) {

    // TODO 계산 로직 : Participant
    fun match(other: Participant): MatchResults {



        val matchResultCollection = calculateMatchResults(other)

        val result = MatchResults(matchResultCollection)
        return result
    }

    private fun calculateMatchResults(other: Participant): List<MatchResult> {
        return ballNumbers
            .flatMap { thisNumber ->
                other.ballNumbers
                    .map { otherNumber -> thisNumber.compare(otherNumber) }
                    .filter { it != MatchResult.NOTHING }
            }
    }

    /**
     * 비교 및 설명용으로 남겨둔 메서드
     */
    @SuppressWarnings
    private fun calculateMatchResultsAsis(other: Participant): List<MatchResult> {
        val matchResultCollection = mutableListOf<MatchResult>()
        for (number in ballNumbers) {
            for (otherNumber in other.ballNumbers) {
                val matchResult = number.compare(otherNumber)
                if (matchResult != MatchResult.NOTHING) {
                    matchResultCollection.add(matchResult)
                    break
                }
            }
        }
        return matchResultCollection
    }
}