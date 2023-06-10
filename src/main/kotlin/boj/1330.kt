package boj

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(when {
        n < k -> "<"
        n > k -> ">"
        else -> "=="
    })
}
