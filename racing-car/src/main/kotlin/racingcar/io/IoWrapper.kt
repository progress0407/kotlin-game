package racingcar.io

import java.io.InputStream
import java.util.*

class IoWrapper(inputStream: InputStream) {

    private val scanner: Scanner

    init {
        this.scanner = Scanner(inputStream)
    }

    fun readLine(): String = scanner.nextLine()

    fun readNumber(): Int = scanner.nextInt()
}

