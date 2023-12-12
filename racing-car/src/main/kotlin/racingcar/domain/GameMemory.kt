package racingcar.domain

/**
 * 게임의 상태를 공유하기 위한 Wrapper 객체
 */
data class GameMemory(var gameState: GameState = GameState.INPUT) {

    var cars: Cars? = null

    fun inputCars(cars: Cars) {
        this.cars = cars
    }

    fun nextTurn() {
        gameState = gameState.nextState()
    }

    fun isRunningGame() = isEndGame().not()

    private fun isEndGame() = cars!!.hasWinner()
}
