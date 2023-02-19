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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (movingStrategy != other.movingStrategy) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + movingStrategy.hashCode()
        result = 31 * result + position
        return result
    }

    override fun toString(): String {
        return "Car(name='$name', movingStrategy=$movingStrategy, position=$position)"
    }
}