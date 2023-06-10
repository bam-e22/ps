package programmers

import java.util.*
import kotlin.Comparator

//val visited = Array(tickets.size) { booleanArrayOf(false, false) }
//dfs(tickets, visited, "ICN", mutableListOf("ICN"))

/*fun solution(tickets: Array<Array<String>>): Array<String> {

    data class Travel(
            val city: String,
            val path: List<String>,
            val visited: BooleanArray
    )

    val pq = PriorityQueue<Travel> { t1, t2 ->
        if (t1.city != t2.city) t1.city.compareTo(t2.city)
        else t1.path.size - t2.path.size

    }
    pq.add(Travel(
            "ICN",
            listOf("ICN"),
            BooleanArray(tickets.size)
    ))

    while (pq.isNotEmpty()) {
        val travel = pq.poll()
        //println("poll >> $travel")
        if (travel.visited.all { it }) {
            return travel.path.toTypedArray()
        }
        tickets.forEachIndexed { index, (start, destination) ->
            if (!travel.visited[index] && travel.city == start) {
                val copy = travel.visited.copyOf()
                copy[index] = true
                pq.add(
                        Travel(
                                destination,
                                travel.path + destination,
                                copy
                        )
                )
            }
        }
    }
    return emptyArray()
}*/

val pq = PriorityQueue<String>()

fun dfs(tickets: Array<Array<String>>, visited: BooleanArray, city: String, history: List<String>) {
    if (visited.all { it }) {
        pq.add(history.joinToString(","))
    }
    for (i in tickets.indices) {
        val ticket = tickets[i]
        if (visited[i]) continue
        if (ticket[0] == city) {
            visited[i] = true
            dfs(tickets, visited, tickets[i][1], history + ticket[1])
            visited[i] = false
        }
    }
}

fun solution(tickets: Array<Array<String>>): Array<String> {
    val visited = BooleanArray(tickets.size)
    //tickets.sortBy { it[1] }
    dfs(tickets, visited, "ICN", listOf("ICN"))
    return pq.poll().split(",").toTypedArray()
}

/*var check = booleanArrayOf()
val stack: Stack<String> = Stack()
val list: MutableList<String> = mutableListOf()

fun solution(tickets: Array<Array<String>>): Array<String> {
    for (i in tickets.indices) {
        if (tickets[i][0] == "ICN") {
            check = BooleanArray(tickets.size)
            check[i] = true
            stack.push("ICN"); stack.push(tickets[i][1])
            dfs(tickets, 1)
            stack.pop(); stack.pop()
        }
    }
    return list.sorted()[0].split(",").toTypedArray()
}

fun dfs(tickets: Array<Array<String>>, depth: Int) {
    if (depth == tickets.size) {
        list.add(stack.joinToString(","))
    } else {
        val nextDestination = stack.peek()
        for (i in tickets.indices) {
            if (check[i]) continue
            if (tickets[i][0] == nextDestination) {
                check[i] = true
                stack.add(tickets[i][1])
                dfs(tickets, depth + 1)
                stack.pop()
                check[i] = false
            }
        }
    }
}*/

fun main() {
    println(solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))).contentToString())
    println(solution(arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL", "SFO"))).contentToString())
    val arr = arrayOf(
            arrayOf("ICN", "A"),
            arrayOf("A", "B"),
            arrayOf("A", "C"),
            arrayOf("C", "A"),
            arrayOf("B", "D"),
    )
    val result = solution(arr)
    println(result.contentToString())

    println(solution(arrayOf(arrayOf("ICN", "AAA"), arrayOf("ICN", "BBB"), arrayOf("BBB", "ICN"))).contentToString())
    println(solution(arrayOf(arrayOf("ICN", "AAA"), arrayOf("AAA", "BBB"), arrayOf("BBB", "AAA"), arrayOf("AAA", "ICN"), arrayOf("ICN", "AAA"))).contentToString())
}
