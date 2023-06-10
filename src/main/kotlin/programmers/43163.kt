package programmers

import java.util.*

class Solution43163 {
    fun isDIffOneChar(a: String, b: String): Boolean {
        var count = 0
        a.forEachIndexed { index, c ->
            if (c != b[index]) {
                count++
            }
            if (count > 1) return false
        }
        return count == 1
    }

    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val visited = BooleanArray(words.size)
        val queue = LinkedList<Pair<String, Int>>()
        queue.add(begin to 0)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            //println("peek >> node= \"$node\"")
            if (node.first == target) {
                //println("fount target: $target, answer= ${node.second}")
                return node.second
            }
            val indexOfNode = words.indexOf(node.first)
            if (indexOfNode != -1) {
                visited[indexOfNode] = true
            }
                    //println("indexOfNode= $indexOfNode")
            for (i in words.indices) {
                if (visited[i]) continue
                val word = words[i]
                if (isDIffOneChar(node.first, word)) {
                    queue.add(word to node.second + 1)
                    //println("   queue >> add= \"$word\"")
                }
            }
        }

        return answer
    }
}

fun main() {
    val s = Solution43163()
    val answer = s.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    println("1. answer= $answer")
    /*val answer2 = s.solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log"))
    println("2. answer2= $answer2")*/
}
