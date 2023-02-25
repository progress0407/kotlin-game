import javax.swing.JFrame

class Breakout : JFrame() {

    init {
        add(Board())
        title = "Breakout"

        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        isResizable = false
        pack()
    }
}
