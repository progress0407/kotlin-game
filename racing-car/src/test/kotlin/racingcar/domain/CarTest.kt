package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.moving.CarFixedMovingStrategy

class CarTest : DescribeSpec({

    describe("move() 메서드는") {

        context("움직이면") {

            val car = Car("foo", CarFixedMovingStrategy())
            car.move()

            it("위치 값이 1 증가한다") {
                car.position shouldBe 1
            }
        }
    }
})