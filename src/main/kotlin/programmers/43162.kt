package programmers

fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val visited = BooleanArray(n)
    for (v in 0 until n) {
        if (!visited[v]) {
            dfs(v, computers, visited)
            answer++
        }
    }

    return answer
}

fun dfs(v: Int, computers: Array<IntArray>, visited:BooleanArray) {
    visited[v] = true
    computers[v].forEachIndexed { index, connected ->
        if (connected == 1 && !visited[index]) {
            dfs(index, computers, visited)
        }
    }
}


fun main() {
    val arr = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    //val arr = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))

    val result = solution(3, arr)

    println("result= $result")
}
