package programmers

// https://school.programmers.co.kr/learn/courses/30/lessons/43165


class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val arr = IntArray(numbers.size)


        answer = dfs(numbers, arr, 0, target)

        return answer
    }

    private fun dfs(numbers: IntArray, arr: IntArray, depth: Int, target: Int): Int {
        var answer = 0
        if (depth == numbers.size) {
            if (arr.sum() == target) {
                return 1
            }
            return 0
        }

        // set minus
        arr[depth] = -numbers[depth]
        answer += dfs(numbers, arr, depth + 1, target)
        // set plus
        arr[depth] = numbers[depth]
        answer += dfs(numbers, arr, depth + 1, target)

        return answer
    }
}


fun main() {
    /*val s = Solution()
    println(s.solution(intArrayOf(4, 1, 2, 1), 2))*/

    val numbers = intArrayOf(1, 2, 3)

    numbers.fold(listOf(0)) { acc, i ->
        println("i= $i")
        val a = acc.run {
            val b = map { it + i }
            val c = map { it - i }
            b + c
        }
        println("a= $a")
        a
    }
}
