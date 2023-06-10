package programmers

fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
    var answer: Int = -1

    return answer
}

fun main() {
    val gameBoard = arrayOf(
            intArrayOf(1, 1, 0, 0, 1, 0),
            intArrayOf(0, 0, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 0, 0, 1),
            intArrayOf(1, 1, 0, 1, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0, 0)
    )
    val table = arrayOf(
            intArrayOf(1, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 0, 0),
            intArrayOf(1, 1, 0, 1, 1, 0),
            intArrayOf(0, 1, 0, 0, 0, 0)
    )
    println(solution(gameBoard, table))
}
