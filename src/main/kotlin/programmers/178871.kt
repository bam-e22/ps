package programmers

fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    val cache = mutableMapOf<String, Int>()
    callings.forEach {

        val index = if (cache.containsKey(it)) {
            cache[it]
        } else {
            players.indexOf(it)
        }!!

        players[index] = players[index - 1]
        cache[players[index - 1]] = index
        players[index - 1] = it
        cache[it] = index - 1
    }
    return players
}

fun main() {
    val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    val callings = arrayOf("kai", "kai", "mine", "mine")
    println(solution(players, callings).contentToString())
}
