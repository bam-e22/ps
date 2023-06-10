package boj

fun main() {
    val (h, m) = readln().split(" ").map { it.toInt() }

    if (m - 45 < 0) {
        val minute = 60 + (m - 45)
        val hour = if (h - 1 < 0) {
            24 + (h - 1)
        } else {
            h - 1
        }
        println("${hour} ${minute}")
    } else {
        println("$h ${m - 45}")
    }
}
