package game

import javazoom.jl.player.Player
import support.FileIoWrapper.Companion.readMusicPlayer
import java.io.File

class Music(
    private val musicName: String,
    private var repeatPlay: Boolean
) : Thread() {

    private var player: Player
    private lateinit var file: File

    init {
        player = readMusicPlayer(musicName)
    }

    override fun run() {
        do {
            player.play()
            player = readMusicPlayer(musicName)
        } while (repeatPlay)
    }

    fun getTime(): Int {
        if (player == null) {
            return 0
        }

        return player.position
    }

    fun close() {
        repeatPlay = false
        player.close()
        this.interrupt()
    }
}
