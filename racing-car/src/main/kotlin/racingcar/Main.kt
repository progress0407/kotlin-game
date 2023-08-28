package racingcar

import racingcar.domain.GameMemory
import racingcar.domain.moving.CarRandomMovingStrategy
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
