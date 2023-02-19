@file:Suppress("NonAsciiCharacters")

package racingcar.domain.moving

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat

class CarRandomMovingStrategyTest : StringSpec({

    val carRandomMovingStrategy = CarRandomMovingStrategy()
    val `총 시행 횟수` = 10_000
    var `움직인 횟수` = 0

    "isMoveStatus()는 60%의 확률로 이동한다" {

        for (i in 1..`총 시행 횟수`) {
            if (carRandomMovingStrategy.isMoveStatus()) {
                `움직인 횟수`++
            }
        }

        val `움직일 확률` = 100 * `움직인 횟수` / `총 시행 횟수`

        assertThat(`움직일 확률`).isCloseTo(60, Assertions.withinPercentage(5))
    }
})