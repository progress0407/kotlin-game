package racingcar

import racingcar.domain.GameMemory
import racingcar.domain.moving.CarRandomMovingStrategy
import racingcar.io.IoWrapper
import racingcar.time.TimeDelay

fun main() {
    val timeDelay = TimeDelay(800)
    val gameMemory = GameMemory()
    val io = IoWrapper(System.`in`)
    val movingStrategy = CarRandomMovingStrategy()

    val game = CarGameApp(gameMemory, timeDelay, io, movingStrategy)

    game.run()
}
