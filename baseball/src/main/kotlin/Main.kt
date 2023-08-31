import app.BaseBallGame
import app.io.IoWrapper

class Main

fun main() {
    val io = IoWrapper(System.`in`)
    val baseBallGame = BaseBallGame(io)
    baseBallGame.run()
}
