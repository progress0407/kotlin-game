package tetris.sample

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel

class RoundedRectPanel : JPanel() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2d = g as Graphics2D
        g2d.color = Color.RED
        g2d.fillRoundRect(100, 100, 200, 100, 20, 20)
    }
}

fun main() {
    val frame = JFrame("Rounded Rectangle")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.contentPane = RoundedRectPanel()
    frame.preferredSize = Dimension(500, 500)
    frame.pack()
    frame.isVisible = true
}