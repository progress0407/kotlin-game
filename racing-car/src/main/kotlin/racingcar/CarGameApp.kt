package racingcar

import racingcar.domain.GameMemory
import racingcar.domain.GameState
import racingcar.domain.states.EndingCarGame
import racingcar.domain.states.InputCarGame
import racingcar.domain.states.RunningCarGame

fun main() {

    val game = CarGameApp()

    game.run()
}

class CarGameApp() {

    private val gameMemory = GameMemory()

    private val inputGame = InputCarGame(gameMemory)
    private val runningGame = RunningCarGame(gameMemory)
    private val endGame = EndingCarGame(gameMemory)

    fun run() {

        while (true) {
            when (gameMemory.gameState) {
                GameState.INPUT -> inputGame.run()
                GameState.RUNNING -> runningGame.run()
                GameState.END -> {
                    endGame.run()
                    break
                }
            }
        }
    }
}


operator fun String.times(repeatNo: Int): String =

    this.repeat(repeatNo)
