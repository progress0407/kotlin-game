package racingcar.domain.moving

class CarFixedMovingStrategy : CarMovingStrategy {

    private var isMoveStatus: Boolean = true

    override fun isMoveStatus(): Boolean = isMoveStatus

    fun changeMoveStatus(moveStatus: Boolean) {

        this.isMoveStatus = moveStatus
    }
}