package boj

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println("${a + b}");
    }
}
