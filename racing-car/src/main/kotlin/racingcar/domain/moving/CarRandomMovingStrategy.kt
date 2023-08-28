package racingcar.domain.moving

import java.util.Random

class CarRandomMovingStrategy : CarMovingStrategy {

    private val random = Random()

    override fun isMoveStatus(): Boolean {

        val randomNo = random.nextInt(10)

        // TODO Refactor This !!
        if (randomNo in 0..3) {
            return false
        }
        return true
    }
}
