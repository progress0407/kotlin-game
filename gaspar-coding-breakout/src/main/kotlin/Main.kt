import java.awt.EventQueue

fun main() {
    EventQueue.invokeLater {
        val game = Breakout()
        game.isVisible = true
    }
}
