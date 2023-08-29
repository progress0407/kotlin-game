package app

import app.io.IoWrapper
import app.participant.Computer
import app.participant.Player
import java.util.Random
import java.util.Scanner
import kotlin.random.asKotlinRandom

class BaseBallGame(private val io: IoWrapper) {

    fun run() {
        while (true) {
            val computer = Computer(computerNumbers())
            println("### Computer Number = ${computer.ballNumbers} ###")
            while (true) {
                println("숫자를 입력해 주세요 : ")
                val numbersString = io.inputString()
                val numbers = convertToValueObjects(numbersString)
                val player = Player(numbers)
                val matchResults = computer.match(player)
                println(view(matchResults))
                if (matchResults.isAllStrike()) {
                    break
                }
            }
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val continueJudgeNumber = io.inputNumber()
            if (continueJudgeNumber == 2) {
                break
            }
        }
    }

    private fun computerNumbers(): List<BallNumber> {

        val n = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val r = 3
        val ballNumbers = permutation(n, r)[randomNumber()]
            .mapIndexed { index, value -> BallNumber(index, value) }

        return ballNumbers
    }



    private fun convertToValueObjects(numbersString: String) = numbersString.toCharArray().withIndex()
        .map { BallNumber(it.index, it.value.code - '0'.code) }
        .toList()

    private fun randomNumber(): Int {
        return Random().asKotlinRandom().nextInt(0, 9 * 8 * 7 + 1)
    }

    private fun view(result: MatchResults) =
        when {
            result.ballAndStrikeCase() ->
                "${result.ball}볼 ${result.strike}스트라이크"

            result.ballCase() ->
                "${result.ball}볼"

            result.strikeCase() ->
                "${result.strike}스트라이크"

            else ->
                "낫싱"
        }
}
