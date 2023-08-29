package app

import app.participant.Computer
import app.participant.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ComputerTest : StringSpec({

    "ALL 스트라이크인 경우" {
        val player = Player(numbers(1, 2, 3))
        val computer = Computer(numbers(1, 2, 3))

        val matchResults = computer.match(player)

        matchResults.isAllStrike() shouldBe true
    }

    "1스트라이크인 경우" {
        val player = Player(numbers(1, 2, 3))
        val computer = Computer(numbers(1, 5, 6))

        val matchResults = computer.match(player)

        matchResults.strike shouldBe 1
        matchResults.ball shouldBe 0
    }

    "1볼인 경우" {
        val player = Player(numbers(1, 2, 3))
        val computer = Computer(numbers(5, 1, 6))

        val matchResults = computer.match(player)

        matchResults.ball shouldBe 1
        matchResults.strike shouldBe 0
    }

    "2볼 1스트라이크 인 경우" {
        val player = Player(numbers(1, 2, 3))
        val computer = Computer(numbers(1, 3, 2))

        val matchResults = computer.match(player)

        matchResults.strike shouldBe 1
        matchResults.ball shouldBe 2
    }

    "3볼인 경우" {
        val player = Player(numbers(1, 2, 3))
        val computer = Computer(numbers(2, 3, 1))

        val matchResults = computer.match(player)

        matchResults.ball shouldBe 3
        matchResults.strike shouldBe 0
    }
})

private fun numbers(first: Int, second: Int, third: Int) =
    listOf(BallNumber(0, first), BallNumber(1, second), BallNumber(2, third))
