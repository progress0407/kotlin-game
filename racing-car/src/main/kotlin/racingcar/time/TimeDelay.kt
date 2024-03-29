package racingcar.time

class TimeDelay(private val milliSecond: Long) {

    constructor() : this(0)

    fun delay() {

        if (milliSecond == 0L) {
            return
        }

        Thread.sleep(milliSecond)
    }

}
