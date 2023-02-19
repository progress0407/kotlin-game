package racingcar.domain.states

import racingcar.domain.GameMemory

class EndingCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

    override fun execute() {

        val winnerNamesJoined = gameMemory.cars!!.winners().joinToString { it.name }
        println("${winnerNamesJoined}가 최종 우승했습니다.")
    }
}
