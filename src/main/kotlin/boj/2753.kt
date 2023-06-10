package boj

fun main() {
    val year = readln().toInt()
    val b = (year % 4 == 0 && year % 100 != 0)|| year % 400 == 0
    println(if (b) 1 else 0)
}
