package racingcar.domain.integration

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.moving.CarFixedMovingStrategy

class CarIntegrationTest : StringSpec({

    val movingStrategy = CarFixedMovingStrategy()
    val car = Car("philz", movingStrategy)

    "Fake Moving Strategy로 Car의 움직임을 제어한다" {

        car.move()
        car.position shouldBe 1

        movingStrategy.changeMoveStatus(false)
        car.move()
        car.position shouldBe 1

        movingStrategy.changeMoveStatus(true)
        car.move()
        car.position shouldBe 2
    }

})
