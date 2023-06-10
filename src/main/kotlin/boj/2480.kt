package boj

fun main() {
    val arr = IntArray(7) { 0 }
    readln().split(" ").forEach {
        val num = it.toInt()
        arr[num] += 1
    }

    val result = when(arr.max()) {
        3 -> arr.lastIndexOf(3) * 1000 + 10000
        2 -> arr.lastIndexOf(2) * 100 + 1000
        1 -> arr.lastIndexOf(1) * 100
        else -> 0
    }
    println(result)
}
