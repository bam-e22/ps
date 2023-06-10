package boj

/*fun main() {
    val n = readln().toInt() // 컴퓨터의 수
    val m = readln().toInt() // 컴퓨터 쌍 입력 수

    val edge = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        edge[a].add(b)
        edge[b].add(a)
    }

    val virus = dfs(edge, visited, 1)

    print(virus - 1)
}

fun dfs(edge: Array<MutableList<Int>>, visited: BooleanArray, node: Int): Int {
    visited[node] = true
    println("visit $node")
    edge[node].forEach {
        if (!visited[it]) {
            dfs(edge, visited, it)
        }
    }
    return visited.count { it }
}*/

fun main() {
    val n = readln().toInt() // 컴퓨터의 수
    val m = readln().toInt() // 컴퓨터 쌍 입력 수

    val edge = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        edge[a].add(b)
        edge[b].add(a)
    }

    val queue = mutableListOf<Int>()
    queue.add(1)
    visited[1] = true
    while(queue.isNotEmpty()) {
        val node = queue.removeFirst()
        edge[node].forEach {
            if (!visited[it]) {
                queue.add(it)
                visited[it] = true
            }
        }
    }

    val virus = visited.count { it } - 1
    println(virus)
}
