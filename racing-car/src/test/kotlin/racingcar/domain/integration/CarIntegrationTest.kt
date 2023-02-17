package racingcar.domain.integration

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.moving.CarFixedMovingStrategy

class CarIntegrationTest {

    @Test
    fun `테스트 픽스쳐를 이용해서 자동차의 움직임을 제어할 수 있다자동차는 move를`() {
        val movingStrategy: CarFixedMovingStrategy = CarFixedMovingStrategy()
        val car = Car("philz", movingStrategy)

        car.move()
        assertThat(car.position).isEqualTo(1);

        movingStrategy.changeMoveStatus(false)
        car.move()
        assertThat(car.position).isEqualTo(1);

        movingStrategy.changeMoveStatus(true)
        car.move()
        assertThat(car.position).isEqualTo(2);
    }
}