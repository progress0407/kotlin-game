package racingcar.domain.states

import racingcar.domain.Car
import racingcar.domain.GameMemory
import racingcar.time.TimeWrapper
import racingcar.times

class RunningCarGame(
    gameMemory: GameMemory,
    private val timeWrapper: TimeWrapper
) : CarGame(gameMemory) {

    override fun execute() {
        println("실행 결과")

        while (gameIsRunning()) {
            moveCars()
            displayCars()
            delay()
        }
    }

    private fun moveCars() = gameMemory.cars?.move()

    private fun displayCars() = display(gameMemory.cars!!.values())

    private fun delay() = timeWrapper.delay()

    private fun gameIsRunning() = !gameMemory.isEndGame()

    private fun display(cars: List<Car>) {

        for (car in cars) {
            display(car)
        }

        printEmptyLine()
    }

    private fun display(car: Car) {

        val visualizedPosition = "-" * car.position
        println("${car.name}: $visualizedPosition")
    }

    private fun printEmptyLine() = println()
}