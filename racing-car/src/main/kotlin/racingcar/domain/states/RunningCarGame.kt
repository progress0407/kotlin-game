package racingcar.domain.states

import racingcar.domain.Car
import racingcar.domain.GameMemory
import racingcar.domain.move
import racingcar.times

class RunningCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

    private val cars = gameMemory.cars

    override fun execute() {
        println("실행 결과")

        while (!gameMemory.isEndGame()) {
            cars.move()
            display(cars)
            Thread.sleep(400)
        }
    }

    private fun display(cars: List<Car>) {
        for (car in cars) {
            display(car)
        }
        println()
    }

    private fun display(car: Car) {
        val visualizedPosition = "-" * car.position
        println("${car.name}: $visualizedPosition")
    }
}