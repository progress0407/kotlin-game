package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.domain.fixture.CarFixture

class CarsTest : DescribeSpec({

    describe("move()는") {

        val car1 = CarFixture.FIRST_CAR()
        val car2 = CarFixture.NOT_MOVED_CAR()
        val cars = Cars(listOf(car1, car2), 5)

        context("자동차들이 움직이면") {

            cars.move()

            it("위치 값이 증가한다") {

                car1.position shouldBe 1
                car2.position shouldBe 0
            }
        }
    }

    describe("winner() 는") {

        val car1 = CarFixture.FIRST_CAR()
        val car2 = CarFixture.SECOND_CAR()
        val car3 = CarFixture.NOT_MOVED_CAR()
        val winNumber = 5
        val cars = Cars(listOf(car1, car2, car3), winNumber)

        context("경주를 한 결과") {

            for (i in 1..winNumber) {
                cars.move()
            }

            it("우승자들을 선출한다") {
                val winners: List<Car> = cars.winners()

                winners shouldHaveSize 2
                winners shouldContainExactlyInAnyOrder listOf(car1, car2)
            }
        }
    }
})