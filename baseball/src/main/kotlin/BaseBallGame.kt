import java.util.Random
import java.util.Scanner
import kotlin.random.asKotlinRandom

class BaseBallGame {

    private val scanner = Scanner(System.`in`)

    fun run() {
        val computer = Computer(computerNumbers())
        println("computer.numbers = ${computer.numbers}")
        println("숫자를 입력해 주세요 : ")
        val numbersString = inputNumber()
        val numbers = convert(numbersString)
        val player = Player(numbers)
        val matchResults = computer.match(player)
        println("matchResults = ${matchResults}")
        println(view(matchResults))
    }

    private fun computerNumbers(): List<Number> {

        val n = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val r = 3
        val numbers = permutation(n, r)[randomNumber()]
            .mapIndexed { index, value -> Number(index, value) }

        return numbers
    }

    private fun inputNumber() = scanner.nextLine()!!

    private fun convert(numbersString: String) = numbersString.toCharArray().withIndex()
        .map { Number(it.index, it.value.code) }
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
