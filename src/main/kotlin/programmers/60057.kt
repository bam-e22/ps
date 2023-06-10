package programmers

import kotlin.math.min

private fun solution(s: String): Int {
    var answer = s.length

    for (i in 1..s.length/2) {
        answer = min(answer, s.encode(i).length)
    }
    return answer
}

fun String.encode(n: Int): String {
    val chunked = chunked(n)
    var count = 1
    var result = StringBuilder()
    chunked.forEachIndexed { index, str ->
        if (index < chunked.size -1) {
            if (str == chunked[index + 1]) {
                count++
            }else {
                result.append(if (count == 1) str else "$count$str")
                count = 1
            }
        } else {
            result.append(if (count == 1) str else "$count$str")
        }
    }
    return result.toString()
}

fun main() {

/*    solution("aabbaccc").let {
        println("1. $it")
    }
    solution("ababcdcdababcdcd").let {
        println("1. $it")
    }
    solution("abcabcdede").let {
        println("1. $it")
    }
    solution("abcabcabcabcdededededede").let {
        println("1. $it")
    }
    solution("xababcdcdababcdcd").let {
        println("1. $it")
    }*/


}
