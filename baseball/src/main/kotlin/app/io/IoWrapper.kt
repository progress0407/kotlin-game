package app.io

import java.io.InputStream
import java.util.*

class IoWrapper(inputStream: InputStream) {

    private val scanner: Scanner

    init {
        this.scanner = Scanner(inputStream)
    }

    fun inputString() = scanner.nextLine()!!
    fun inputNumber() = scanner.nextInt()
}
