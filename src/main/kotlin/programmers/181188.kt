package programmers


fun solution(targets: Array<IntArray>): Int {
    var answer: Int = 0
    targets.sortWith { t1, t2 ->
        val a = t1[1].compareTo(t2[1])
        if (a == 0) {
            t1[0].compareTo(t2[0])
        } else {
            a
        }
    }
    println(targets.contentDeepToString())
    var end = 0
    targets.forEach {(s, e) ->
        if (s >= end) {
            end = e
            answer++
        }
    }
    return answer
}

fun main() {
    solution(arrayOf(
            intArrayOf(4, 5),
            intArrayOf(4, 8),
            intArrayOf(10, 14),
            intArrayOf(11, 13),
            intArrayOf(5, 12),
            intArrayOf(3, 7),
            intArrayOf(1, 4))
    ).let {
        println(it)
    }
}
