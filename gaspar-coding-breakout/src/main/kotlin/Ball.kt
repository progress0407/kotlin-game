import Commons.Companion.DOWNWARD_DIRECTION
import Commons.Companion.LEFT_DIRECTION
import Commons.Companion.RIGHT_DIRECTION
import Commons.Companion.UPWARD_DIRECTION
import java.awt.Point

class Ball : Sprite() {

    private var xDir: Int = LEFT_DIRECTION
    private var yDir: Int = RIGHT_DIRECTION

    init {
        loadImage("ball.png")
        setImageDimensions()
        resetState()
    }

    fun move() {

        changeCoordinate()
        changeDirectionIfHitWall()
    }

    fun isWindowOut(): Boolean = super.awtRectangle().maxY > Commons.BOTTOM_EDGE

    fun isHitTo(sprite: Sprite): Boolean {

        val ballRectangle = awtRectangle()
        val targetRectangle = sprite.awtRectangle()

        if (sprite is Brick) {
            return sprite.isAlive() && ballRectangle.intersects(targetRectangle)
        }

        return ballRectangle.intersects(targetRectangle)
    }

    fun changeDirectionFor(paddle: Paddle) {

        val paddleRectangle = paddle.awtRectangle()
        val paddleGrid = paddleRectangle.width / 5

        val paddleLeftCoord = paddleRectangle.minX
        val ballLeftCoord = this.awtRectangle().minX

        val paddleGrids = arrayOf(
            paddleLeftCoord + paddleGrid * 1,
            paddleLeftCoord + paddleGrid * 2,
            paddleLeftCoord + paddleGrid * 3,
            paddleLeftCoord + paddleGrid * 4
        )

        if (ballLeftCoord < paddleGrids[0]) {
            changeDirectionToLeftUp()
        }

        if (ballLeftCoord in paddleGrids[0]..paddleGrids[1]) {
            changeDirectionToSlightlyLeftUp()
        }

        if (ballLeftCoord in paddleGrids[1]..paddleGrids[2]) {
            changeDirectionToUp()
        }

        if (ballLeftCoord in paddleGrids[2]..paddleGrids[3]) {
            changeDirectionToSlightlyRightUp()
        }

        if (ballLeftCoord > paddleGrids[3]) {
            changeDirectionToRightUp()
        }
    }

    private fun changeDirectionToLeftUp() {

        xDir = LEFT_DIRECTION
        yDir = UPWARD_DIRECTION
    }

    private fun changeDirectionToSlightlyLeftUp() {

        xDir = LEFT_DIRECTION
        yDir = reverseYDir()
    }

    private fun changeDirectionToUp() {
        xDir = 0
        yDir = reverseYDir()
    }

    private fun changeDirectionToSlightlyRightUp() {

        xDir = RIGHT_DIRECTION
        yDir = reverseYDir()
    }

    private fun changeDirectionToRightUp() {

        xDir = RIGHT_DIRECTION
        yDir = UPWARD_DIRECTION
    }

    private fun reverseYDir() = -1 * yDir

    private fun changeCoordinate() {

        x += xDir
        y += yDir
    }

    private fun changeDirectionIfHitWall() {

        if (doesHitWallLeftSide()) {
            xDir = RIGHT_DIRECTION
        }

        if (doesHitWallRightSide()) {
            xDir = LEFT_DIRECTION
        }

        if (doesHitWallUpSide()) {
            yDir = DOWNWARD_DIRECTION
        }
    }

    fun changeDirectionFor(brick: Brick) {

        val rectangle = awtRectangle()

        val ballLeftCoord = rectangle.maxX.toInt()
        val ballTopCoord = rectangle.minY.toInt()
        val ballWidth = rectangle.width.toInt()
        val ballHeight = rectangle.height.toInt()

        val ballLeftPoint = Point(ballLeftCoord - 1, ballTopCoord)
        val ballRightPoint = Point(ballLeftCoord + ballWidth + 1, ballTopCoord)
        val ballTopPoint = Point(ballLeftCoord, ballTopCoord - 1)
        val ballBottomPoint = Point(ballLeftCoord, ballTopCoord + ballHeight + 1)

        if (brick.hitTo(ballRightPoint)) {
            xDir = LEFT_DIRECTION
        } else if (brick.hitTo(ballLeftPoint)) {
            xDir = RIGHT_DIRECTION
        }

        if (brick.hitTo(ballTopPoint)) {
            yDir = DOWNWARD_DIRECTION
        } else if (brick.hitTo(ballBottomPoint)) {
            yDir = UPWARD_DIRECTION
        }
    }

    private fun doesHitWallLeftSide() = x == 0

    private fun doesHitWallRightSide() = x == Commons.WINDOW_WIDTH - imageWidth

    private fun doesHitWallUpSide() = y == 0

    private fun resetState() {
        x = Commons.INIT_BALL_X
        y = Commons.INIT_BALL_Y
    }

    override fun toString(): String {
        return "Ball(xDir=$xDir, yDir=$yDir)"
    }
}
