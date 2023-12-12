package racingcar.domain.moving

/**
 * 테스트 코드에서 사용할 Strategy 구현체
 */
class CarFixedMovingStrategy : CarMovingStrategy {

    private var isMoveStatus: Boolean = true

    override fun isMoveStatus(): Boolean = isMoveStatus

    fun changeMoveStatus(moveStatus: Boolean) {

        this.isMoveStatus = moveStatus
    }
}