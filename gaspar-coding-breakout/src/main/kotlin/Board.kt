import Commons.Companion.BRICKS_NUMBER
import Commons.Companion.PERIOD
import Commons.Companion.WINDOW_HEIGHT
import Commons.Companion.WINDOW_WIDTH
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JPanel
import javax.swing.Timer

class Board : JPanel() {

    private var timer: Timer
    private var message: String = "Game Over"
    private val ball = Ball()
    private val paddle = Paddle()
    private val bricks: ArrayList<Brick> = createBricks()

    private var playingGame: Boolean = true

    init {
        addKeyListener(TAdapter())
        isFocusable = true
        preferredSize = Dimension(WINDOW_WIDTH, WINDOW_HEIGHT)
        timer = Timer(PERIOD, GameCycle())
        timer.start()
    }

    override fun paintComponent(graphics: Graphics) {

        super.paintComponent(graphics)

        if (graphics is Graphics2D) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)

            if (playingGame) {
                drawObjects(graphics)
            } else {
                gameFinished(graphics)
            }
        }
    }

    private fun createBricks(): ArrayList<Brick> {

        val bricks: ArrayList<Brick> = arrayListOf()

        for (y in 0 until 5) {
            for (x in 0 until 6) {
                bricks.add(Brick(brickXCoord(x), brickYCoord(y)))
            }
        }

        return bricks
    }

    private fun drawObjects(graphics: Graphics2D) {

        draw(graphics, ball)
        draw(graphics, paddle)
        drawBricks(graphics)
    }

    private fun drawBricks(graphics: Graphics2D) {

        for (brick in bricks) {
            if (brick.isAlive()) {
                draw(graphics, brick)
            }
        }
    }

    private fun draw(graphics: Graphics2D, sprite: Sprite) {

        graphics.drawImage(sprite.image, sprite.x, sprite.y, sprite.imageWidth, sprite.imageHeight, this)
    }

    private fun gameFinished(graphics: Graphics2D) {
        val font = Font("Verdana", Font.BOLD, 18)
        val fontMetrics = this.getFontMetrics(font)

        graphics.color = Color.BLACK
        graphics.font = font
        graphics.drawString(
            message,
            (WINDOW_WIDTH - fontMetrics.stringWidth(message)) / 2,
            WINDOW_WIDTH / 2
        )
    }

    private fun brickXCoord(x: Int) = 30 + 40 * x

    private fun brickYCoord(y: Int) = 50 + 10 * y

    private inner class TAdapter : KeyAdapter() {

        override fun keyPressed(keyEvent: KeyEvent?) {

            paddle.keyPressed(keyEvent!!)
        }

        override fun keyReleased(keyEvent: KeyEvent?) {

            paddle.keyReleased(keyEvent!!)
        }
    }

    private inner class GameCycle : ActionListener {

        override fun actionPerformed(actionEvent: ActionEvent?) {

            doGameCycle()
        }

        private fun doGameCycle() {

            ball.move()
            paddle.move()
            checkCollision()
            repaint()
        }

        private fun checkCollision() {

            checkGameOver()
            checkGameClear()
            checkBallHitPaddle()
            checkBallHitBrick()
        }

        private fun checkGameOver() {
            if (isGameOver()) {

                stopGame()
            }
        }

        private fun checkGameClear() {

            var crashedBrick = 0

            for (brick in bricks) {
                if (brick.destroyed) { // update count of crashed brick
                    crashedBrick++
                }
                checkGameClear(crashedBrick)
            }
        }

        private fun checkGameClear(crashedBrick: Int) {

            if (crashedBrick == BRICKS_NUMBER) {
                message = "congratulation !"
                stopGame()
            }
        }

        private fun checkBallHitPaddle() {

            if (ball.isHitTo(paddle)) {
                ball.changeDirectionFor(paddle)
            }
        }

        private fun checkBallHitBrick() {

            for (brick in bricks) {
                if (ball.isHitTo(brick)) {
                    ball.changeDirectionFor(brick)
                    brick.crash()
                }
            }
        }

        private fun isGameOver() = ball.isWindowOut()

        private fun stopGame() {

            playingGame = false
            timer.stop()
        }
    }
}