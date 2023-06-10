package boj

import kotlin.math.pow

fun main() {
    val a = readln().toInt()
    val b = readln()

    val result = b
        .reversed()
        .mapIndexed { index, c ->
            val r = c.digitToInt() * a
            println(r)
            r * 10.0.pow(index)
        }.sum()

    println(result.toInt())
}
