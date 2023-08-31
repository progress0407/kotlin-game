package racingcar.domain.states

import racingcar.domain.Car
import racingcar.domain.GameMemory
import racingcar.time.TimeDelay
import racingcar.times

class RunningCarGame(
    gameMemory: GameMemory,
    private val timeDelay: TimeDelay
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

    private fun delay() = timeDelay.delay()

    private fun gameIsRunning() = gameMemory.isRunningGame()

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