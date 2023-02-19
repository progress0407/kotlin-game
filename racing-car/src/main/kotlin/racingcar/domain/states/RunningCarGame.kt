package racingcar.domain.states

import racingcar.domain.Car
import racingcar.domain.GameMemory
import racingcar.times

class RunningCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

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

    private fun delay() = Thread.sleep(400)

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