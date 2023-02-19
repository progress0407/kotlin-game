package racingcar.domain

data class GameMemory(
    var gameState: GameState = GameState.INPUT
) {

    var cars: Cars? = null


    fun inputCars(cars: Cars) {
        this.cars = cars
    }

    fun nextTurn() {

        gameState = gameState.nextState()
    }

    fun isEndGame(): Boolean =
        cars!!.hasWinner()
}
