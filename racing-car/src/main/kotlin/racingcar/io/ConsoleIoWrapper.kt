package racingcar.io

import java.util.*

class ConsoleIoWrapper : IoWrapper {

    private val scanner = Scanner(System.`in`)

    override fun readLine(): String {
        return scanner.nextLine()
    }

    override fun readNumber(): Int {
        return scanner.nextInt()
    }
}