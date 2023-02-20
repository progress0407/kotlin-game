package racingcar.domain.states

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.GameMemory
import racingcar.domain.moving.CarMovingStrategy
import racingcar.io.IoWrapper

class InputCarGame(
    gameMemory: GameMemory,
    private val io: IoWrapper,
    private val movingStrategy: CarMovingStrategy
) : CarGame(gameMemory) {

    override fun execute() {

        val carNames = inputCarNames()
        val trialNumbers = inputTrialNumbers()
        val cars = createCars(carNames, trialNumbers)
        inputGameMemory(cars)
    }

    private fun inputCarNames(): List<String> {

        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val inputCarNames = io.readLine()

        return convertCarNames(inputCarNames)
    }

    private fun convertCarNames(line: String): MutableList<String> =
        line.split(",").stream()
            .map { it.trim() }
            .toList()

    private fun inputTrialNumbers(): Int {

        println("시도할 횟수는 몇회인가요?")

        return io.readNumber()
    }

    private fun createCars(carNames: List<String>, trialNumbers: Int): Cars {

        val carCollection = carNames.map { name -> Car(name, movingStrategy) }
            .toList()

        return Cars(carCollection, trialNumbers)
    }

    private fun inputGameMemory(cars: Cars) {

        gameMemory.inputCars(cars)
    }
}