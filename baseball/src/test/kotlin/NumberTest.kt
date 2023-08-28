import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({


    "값과 위치 모두 같은 경우 스트라이크이다" {
        val numberA = Number(0, 3)
        val numberB = Number(0, 3)

        val matchResult = numberA.compare(numberB)

        matchResult shouldBe MatchResult.STRIKE
    }

    "값은 같으나 위치가 다른 경우 볼이다" {
        val numberA = Number(0, 3)
        val numberB = Number(1, 3)

        val matchResult = numberA.compare(numberB)

        matchResult shouldBe MatchResult.BALL
    }

    "값과 위치 모두 다른 경우는 가치가 없다" {
        val numberA = Number(0, 2)
        val numberB = Number(1, 3)

        val matchResult = numberA.compare(numberB)

        matchResult shouldBe MatchResult.NOTHING
    }
})
