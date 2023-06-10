package boj

fun main() {
    val n = readln().toInt() / 4
    val l = "long "
    val sb = StringBuilder()
    for (i in 0 until n) {
        sb.append(l)
    }
    sb.append("int")

    println(sb)
}
