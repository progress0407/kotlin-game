package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import racingcar.domain.GameMemory
import racingcar.domain.GameState
import racingcar.domain.moving.CarFixedMovingStrategy
import racingcar.io.IoWrapper
import racingcar.time.TimeDelay
import java.io.ByteArrayInputStream
import java.io.InputStream

class CarGameAppTest : BehaviorSpec({

    given("bb,cc,aa 자동차가 5회") {

        val inputStream = createInputStream("bb,cc,aa\n5")

        val gameMemory = GameMemory()
        val timeDelay = TimeDelay()
        val io = IoWrapper(inputStream)
        val movingStrategy = CarFixedMovingStrategy()
        val carGameApp = CarGameApp(gameMemory, timeDelay, io, movingStrategy)

        `when`("경주를 하면") {

            carGameApp.run()

            then("메모리 내용을 검증한다") {

                val winners = gameMemory.cars!!.winners()
                val winnerOne = winners[0]
                val winnerNames = winners.map { it.name }

                gameMemory.gameState shouldBe GameState.END
                winnerOne.position shouldBe 5
                winnerNames shouldContainExactly listOf("aa", "bb", "cc")
            }
        }
    }
})

private fun createInputStream(input: String): InputStream {
    val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
    System.setIn(`in`)
    return System.`in`
}
