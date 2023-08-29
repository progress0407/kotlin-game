class Computer(numbers: List<Number>) : Participant(numbers) {

    // TODO 계산 로직 : Participant
    fun match(other: Participant): MatchResults {

        val matchResultCollection = mutableListOf<MatchResult>()
        for (number in numbers) {
            for (otherNumber in other.numbers) {
                val matchResult = number.compare(otherNumber)
                if (matchResult != MatchResult.NOTHING) {
                    matchResultCollection.add(matchResult)
                    break
                }
            }
        }

//        val matchResultCollection: List<MatchResult> = numbers
//            .flatMap { thisNumber ->
//                other.numbers
//                    .map { otherNumber -> thisNumber.compare(otherNumber) }
//                    .filter { it != MatchResult.NOTHING }
//            }

        val result = MatchResults(matchResultCollection)
        return result
    }
}