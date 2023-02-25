package support

import javazoom.jl.player.Player
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.net.URL
import javax.swing.ImageIcon

abstract class FileIoWrapper {

    companion object {

        @JvmStatic
        fun readImageIcon(imagePath: String): ImageIcon {

//        val resource = DynamicBeat::class.java.getResource("images/intro_background.jpg") // fail to load
            val resource = createResource("../images/$imagePath")

            return ImageIcon(resource)
        }

        @JvmStatic
        fun readMusicPlayer(musicPath: String): Player {

            val uri = createResource("../musics/$musicPath").toURI()
            val file = File(uri)
            val bufferedInputStream = BufferedInputStream(FileInputStream(file))

            return Player(bufferedInputStream)
        }

        private fun createResource(path: String): URL =
            this::class.java.getResource(path) ?: throw NullPointerException("\"${path}\"는 null일 수 없어!!")
    }
}