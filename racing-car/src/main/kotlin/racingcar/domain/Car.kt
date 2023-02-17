package racingcar.domain

import racingcar.domain.moving.CarMovingStrategy

data class Car(val name: String, private val movingStrategy: CarMovingStrategy) {

    var position: Int = 0
        private set

    fun move() {
        if (movingStrategy.isMoveStatus()) {
            position++
        }
    }
}