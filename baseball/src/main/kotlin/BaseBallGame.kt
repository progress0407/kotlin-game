import java.util.Random
import java.util.Scanner
import kotlin.random.asKotlinRandom

class BaseBallGame {

    private val scanner = Scanner(System.`in`)

    fun run() {
        val computer = Computer(computerNumbers())
        println("숫자를 입력해 주세요 : ")
        val numbersString = inputNumber()
        val numbers = convert(numbersString)
        val player = Player(numbers)
    }

    private fun computerNumbers(): MutableList<Number> {
        val numbers = mutableListOf<Number>()
        for (index in 0..2) {
            val number = Number(index, randomNumber())
            numbers.add(number)
        }
        return numbers
    }

    private fun inputNumber() = scanner.nextLine()!!

    private fun convert(numbersString: String) = numbersString.toCharArray().withIndex()
        .map { Number(it.index, it.value.code) }
        .toList()

    private fun randomNumber(): Int {
        return Random().asKotlinRandom().nextInt(1, 9 + 1)
    }
}