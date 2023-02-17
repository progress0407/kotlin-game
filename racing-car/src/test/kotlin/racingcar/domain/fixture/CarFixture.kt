package racingcar.domain.fixture

import racingcar.domain.Car
import racingcar.domain.moving.CarFixedMovingStrategy

enum class CarFixture(protected val carName: String) {
    FIRST_CAR("first"),
    SECOND_CAR("second"),
    NOT_MOVED_CAR("not moving car") {

        override fun invoke() : Car {
            val movingStrategy = CarFixedMovingStrategy()
            val car = Car(super.carName, movingStrategy)
            movingStrategy.changeMoveStatus(false)

            return car
        }
    };

    open operator fun invoke(): Car {
        return Car(carName, CarFixedMovingStrategy())
    }
}