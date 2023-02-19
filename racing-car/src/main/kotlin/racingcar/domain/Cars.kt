package racingcar.domain


class Cars(
    private val cars: List<Car>,
    private val trialNumbers: Int
) {

    fun move() {

        for (car in cars) {
            car.move()
        }
    }

    fun winners(): List<Car> =
        cars.stream()
            .filter { it.position >= trialNumbers }
            .sorted(compareBy { it.name })
            .toList()

    fun hasWinner(): Boolean =
        winners()
            .isNotEmpty()

    fun values() = cars
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cars

        if (cars != other.cars) return false
        if (trialNumbers != other.trialNumbers) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cars.hashCode()
        result = 31 * result + trialNumbers
        return result
    }

    override fun toString(): String {
        return "Cars(cars=$cars, trialNumbers=$trialNumbers)"
    }
}
