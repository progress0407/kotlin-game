package racingcar

import racingcar.domain.GameMemory
import racingcar.domain.GameState.*
import racingcar.domain.moving.CarMovingStrategy
import racingcar.domain.moving.CarRandomMovingStrategy
import racingcar.domain.states.EndingCarGame
import racingcar.domain.states.InputCarGame
import racingcar.domain.states.RunningCarGame
import racingcar.io.IoWrapper
import racingcar.time.TimeWrapper

fun main() {

    val timeWrapper = TimeWrapper(800)
    val gameMemory = GameMemory()
    val io = IoWrapper(System.`in`)
    val movingStrategy = CarRandomMovingStrategy()

    val game = CarGameApp(gameMemory, timeWrapper, io, movingStrategy)

    game.run()
}

class CarGameApp(
    private val gameMemory: GameMemory,
    private val timeWrapper: TimeWrapper,
    io: IoWrapper,
    movingStrategy: CarMovingStrategy
) {


    private val inputGame = InputCarGame(gameMemory, io, movingStrategy)
    private val runningGame = RunningCarGame(gameMemory, timeWrapper)
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
