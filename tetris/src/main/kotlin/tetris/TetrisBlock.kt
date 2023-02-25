package tetris

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class TetrisBlock(color: Color) : JPanel() {
    private var color = color

    fun setColor(color: Color) {
        this.color = color
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.color = color
        g.fillRect(0, 0, width, height)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val block = TetrisBlock(Color.RED)
            block.setSize(20, 20)
            block.isVisible = true
        }
    }
}
