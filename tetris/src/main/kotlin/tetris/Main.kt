package tetris

import java.awt.Color
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

fun main() {
    val frame = JFrame()
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.title = "Tetris"
    frame.setSize(500, 500)
    frame.isVisible = true

    val contentPane = JPanel()
    contentPane.background = Color.WHITE
    contentPane.layout = null

    val blockSize = 50
    val centerX = frame.width / 2 - blockSize / 2
    val centerY = frame.height / 2 - blockSize / 2
    val block1 = TetrisBlock(Color.RED)
    block1.setSize(blockSize, blockSize)
    block1.setLocation(centerX, centerY)
    val block2 = TetrisBlock(Color.RED)
    block2.setSize(blockSize, blockSize)
    block2.setLocation(centerX, centerY + blockSize)
    val block3 = TetrisBlock(Color.RED)
    block3.setSize(blockSize, blockSize)
    block3.setLocation(centerX, centerY + 2 * blockSize)
    val block4 = TetrisBlock(Color.RED)
    block4.setSize(blockSize, blockSize)
    block4.setLocation(centerX, centerY + 3 * blockSize)

    contentPane.add(block1)
    contentPane.add(block2)
    contentPane.add(block3)
    contentPane.add(block4)

    val label = JLabel("I straight tetromino")
    label.font = Font("SansSerif", Font.BOLD, 20)
    label.foreground = Color.RED
    label.setLocation(centerX - blockSize * 2, centerY - 50)
    label.setSize(200, 30)
    contentPane.add(label)

    frame.contentPane = contentPane
}