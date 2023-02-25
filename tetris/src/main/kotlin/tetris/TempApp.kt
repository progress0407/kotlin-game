package tetris

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField


fun main() {

    val textField = JTextField()
    textField.text = "hello text"

    val panel = JPanel()
    panel.add(textField)

    val frame = JFrame("프레임")
    frame.setSize(300, 200)
    frame.isVisible = true
    frame.contentPane = panel

    val submitButton = JButton("Submit")
    panel.add(submitButton)

    // Sprite
}

