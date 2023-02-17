package racingcar.domain.states

import racingcar.domain.GameMemory

abstract class CarGame(protected val gameMemory: GameMemory) {

    abstract fun execute()

    fun run() {

        execute()
        gameMemory.nextTurn()
    }
}