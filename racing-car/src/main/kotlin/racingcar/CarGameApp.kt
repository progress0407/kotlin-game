package racingcar

import racingcar.domain.GameMemory
import racingcar.domain.GameState.*
import racingcar.domain.moving.CarRandomMovingStrategy
import racingcar.domain.states.EndingCarGame
import racingcar.domain.states.InputCarGame
import racingcar.domain.states.RunningCarGame
import racingcar.io.ConsoleIoWrapper

fun main() {

    val movingStrategy = CarRandomMovingStrategy()
    val game = CarGameApp(movingStrategy)

    game.run()
}

class CarGameApp(movingStrategy: CarRandomMovingStrategy) {

    private val gameMemory = GameMemory()
    private val io = ConsoleIoWrapper()

    private val inputGame = InputCarGame(gameMemory, io, movingStrategy)
    private val runningGame = RunningCarGame(gameMemory)
    private val endGame = EndingCarGame(gameMemory)

    fun run() {

        while (true) when (gameMemory.gameState) {
            INPUT -> {
                input()
            }

            RUNNING -> {
                runGame()
            }

            END -> {
                end()
                break
            }
        }
    }

    private fun input() {
        inputGame.run()
    }

    private fun runGame() {
        runningGame.run()
    }

    private fun end() {
        endGame.run()
    }
}


operator fun String.times(repeatNo: Int): String = this.repeat(repeatNo)
