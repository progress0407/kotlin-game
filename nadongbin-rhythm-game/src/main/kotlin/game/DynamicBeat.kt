package game

import support.FileIoWrapper.Companion.readImageIcon
import support.delay
import java.awt.Color
import java.awt.Cursor
import java.awt.Graphics
import java.awt.Image
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import java.util.Objects.requireNonNull
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import kotlin.system.exitProcess

private const val SCREEN_WIDTH = 1_280
private const val SCREEN_HEIGHT = 720

class DynamicBeat : JFrame() {

    private lateinit var screenImage: Image
    private lateinit var screenGraphic: Graphics

    private val introBackground = readImageIcon("intro_background.jpg").image

    private val exitButtonImage = readImageIcon("exitButtonBasic.png")
    private val exitButtonEnteredImage = readImageIcon("exitButtonEntered.png")

    private val menuBar = JLabel(readImageIcon("menuBar.png"))
    private val exitButton = JButton(readImageIcon("exitButtonBasic.png"))

    private lateinit var mouseCoordinate: MouseCoordinate

    init {

        preInit()
        addExitButton()
        addMenuBar()
        musicStart()
    }

    private fun preInit() {

        isUndecorated = true // 기본 메뉴바 활성 x
        title = "Dynamic Beat"
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT)
        isResizable = false
        setLocationRelativeTo(null) // 창을 정중앙으로
        defaultCloseOperation = EXIT_ON_CLOSE // 창 종료시 프로그램 종료
        isVisible = true // 창이 보이게
        background = Color(0, 0, 0, 0) // 배경을 회색 -> 흰색
        layout = null // 레이아웃(버튼 등) 초기화
    }

    private fun musicStart() {

        val introMusic = Music("intro_music.mp3", true)
        introMusic.start()
    }

    private fun addMenuBar() {

        menuBar.setBounds(0, 0, 1280, 30)

        menuBar.addMouseListener(object : MouseAdapter() {

            override fun mousePressed(mouseEvent: MouseEvent?) {

                checkMouseEventNotNull(mouseEvent)

                mouseCoordinate = MouseCoordinate(mouseEvent!!.x, mouseEvent.y)
            }
        })

        menuBar.addMouseMotionListener(object : MouseMotionAdapter() {

            override fun mouseDragged(mouseEvent: MouseEvent?) {

                checkMouseEventNotNull(mouseEvent)

                val currentX = mouseEvent!!.x
                val currentY = mouseEvent.y
                setLocation(currentX - mouseCoordinate.x, currentY - mouseCoordinate.y)
            }
        })

        add(menuBar)
    }

    private fun checkMouseEventNotNull(mouseEvent: MouseEvent?) {
        requireNonNull(mouseEvent, "mouse 좌표는 null일 수 없습니다")
    }

    private fun addExitButton() {

        exitButton.setBounds(1245, 0, 30, 30)
        exitButton.isBorderPainted = false
        exitButton.isContentAreaFilled = false
        exitButton.isFocusPainted = false

        exitButton.addMouseListener(object : MouseAdapter() {

            override fun mouseEntered(mouseEvent: MouseEvent?) {

                exitButton.icon = exitButtonEnteredImage
                exitButton.cursor = Cursor(Cursor.HAND_CURSOR)
                val buttonEnteredMusic = Music("buttonEnteredMusic.mp3", false)
                buttonEnteredMusic.start()
            }

            override fun mouseExited(mouseEvent: MouseEvent?) {

                exitButton.icon = exitButtonImage
                exitButton.cursor = Cursor(Cursor.DEFAULT_CURSOR)
            }

            override fun mousePressed(mouseEvent: MouseEvent?) {

                val buttonEnteredMusic = Music("buttonPressedMusic.mp3", false)
                buttonEnteredMusic.start()
                delay(500)
                exitProcess(0)
            }
        })

        add(exitButton)
    }

    override fun paint(graphics: Graphics) {

        screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT)
        screenGraphic = screenImage.graphics
        screenDraw(screenGraphic)
        graphics.drawImage(screenImage, 0, 0, null)
    }

    private fun screenDraw(graphics: Graphics) {

        graphics.drawImage(introBackground, 0, 0, null)
        paintComponents(graphics) // 정적인 이미지 그리기 ex) 메뉴바, 버튼
        repaint() // 주기적으로 repaint
    }
}
