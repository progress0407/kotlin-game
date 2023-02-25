import Commons.Companion.INIT_PADDLE_X
import Commons.Companion.INIT_PADDLE_Y
import Commons.Companion.LEFT_DIRECTION
import Commons.Companion.RIGHT_DIRECTION
import java.awt.event.KeyEvent

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class Paddle : Sprite() {

    private var dx: Int = 0;
    private val wallXLimit: Int

    companion object {

        private val X_DIR_MOVING_KEYS = listOf(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT)
    }

    init {

        loadImage("paddle.png")
        setImageDimensions()
        wallXLimit = Commons.WINDOW_WIDTH - imageWidth

        resetState()
    }

    fun move() {

        x += 2 * dx

        changeDirectionIfHitWall()
    }

    fun keyPressed(keyEvent: KeyEvent) {

        val keyCode = keyEvent.keyCode

        changeDirectionWhenKeyPressed(keyCode)
    }

    fun keyReleased(keyEvent: KeyEvent) {

        val keyCode = keyEvent.keyCode

        if (movingInXDirection(keyCode)) {
            dx = 0
        }
    }

    private fun movingInXDirection(keyCode: Int) = keyCode in X_DIR_MOVING_KEYS

    private fun changeDirectionWhenKeyPressed(keyCode: Int) {

        if (keyCode === KeyEvent.VK_LEFT) {
            dx = LEFT_DIRECTION
        }

        if (keyCode === KeyEvent.VK_RIGHT) {
            dx = RIGHT_DIRECTION
        }
    }

    private fun changeDirectionIfHitWall() {

        if (doesHitLeftWall()) {
            x = 0
        }

        if (doesHitRightWall()) {
            x = wallXLimit
        }
    }

    private fun doesHitLeftWall() = x <= 0

    private fun doesHitRightWall() = x >= wallXLimit

    private fun resetState() {
        x = INIT_PADDLE_X
        y = INIT_PADDLE_Y
    }

    override fun toString(): String {
        return "Paddle(dx=$dx, wallXLimit=$wallXLimit)"
    }
}
