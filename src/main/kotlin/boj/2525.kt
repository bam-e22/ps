package boj

fun main() {
    val (h, m) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()

    val time = Time(h, m)
    val addedTime = Time(c / 60, c % 60)

    println(time + addedTime)
}

data class Time(
    val hour: Int,
    val minute: Int,
) {
    operator fun plus(time: Time): Time {
        val increaseHour = minute + time.minute >= 60
        return Time(
            hour = (hour + time.hour + increaseHour.toInt()) % 24,
            minute = (minute + time.minute) % 60
        )
    }
    override fun toString(): String {
        return "$hour $minute"
    }
}

fun Boolean.toInt(): Int {
    return if (this) 1 else 0
}
