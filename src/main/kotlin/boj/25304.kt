package boj

fun main() {
    val total = readln().toInt()
    val n = readln().toInt()
    var sum = 0
    for (i in 0 until n) {
        val (cost, count) = readln().split(" ").map { it.toInt() }
        sum += (cost * count)
    }
    if (sum == total) {
        println("Yes")
    } else {
        println("No")
    }
}
