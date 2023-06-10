package boj

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        arr[i] = intArrayOf(a, b)
    }

}
