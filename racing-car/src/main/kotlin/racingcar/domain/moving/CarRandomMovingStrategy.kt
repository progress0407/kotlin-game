package racingcar.domain.moving

import java.util.Random

class CarRandomMovingStrategy : CarMovingStrategy {

    private val random = Random()

    override fun isMoveStatus(): Boolean {

        val randomNumber = random.nextInt(10)

        // TODO Refactor This !!
        return randomNumber !in 0..3
    }
}
