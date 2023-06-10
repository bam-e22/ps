package programmers

private val THRESHOLD = 4

fun solution(survey: Array<String>, choices: IntArray): String {
    var answer = ""
    val scoreResult = mutableMapOf<Char, Int>()
    val types = listOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')

    initScore(scoreResult, types)
    score(survey, choices, scoreResult)
    answer = determineType(types, scoreResult)

    return answer
}

private fun determineType(types: List<Char>, scoreResult: MutableMap<Char, Int>): String {
    val answer = StringBuilder()
    with(answer) {
        types.chunked(2).forEach {
            append(selectType(scoreResult, it[0], it[1]))
        }
    }
    return answer.toString()
}

private fun initScore(score: MutableMap<Char, Int>, types: List<Char>) {
    types.forEach {
        score[it] = 0
    }
}

private fun score(survey: Array<String>, choices: IntArray, scoreResult: MutableMap<Char, Int>) {
    for (i in survey.indices) {
        val s = survey[i]
        val c = choices[i]

        if (c > THRESHOLD) { // 동의
            scoreResult[s.last()] = scoreResult[s.last()]!! + choiceToScore(c)
        } else if (c < THRESHOLD) { //비동의
            scoreResult[s.first()] = scoreResult[s.first()]!! + choiceToScore(c)
        }
    }
}

private fun choiceToScore(c: Int): Int {
    return when (c) {
        1, 7 -> 3
        2, 6 -> 2
        3, 5 -> 1
        else -> 0
    }
}

private fun selectType(map: Map<Char, Int>, key1: Char, key2: Char): Char {
    return when {
        map[key1] == map[key2] -> minOf(key1, key2)
        map[key1]!! < map[key2]!! -> key2
        else -> key1
    }
}

fun main() {

    solution(
            arrayOf("AN", "CF", "MJ", "RT", "NA"),
            intArrayOf(5, 3, 2, 7, 5)
    ).let {
        println("1. answer= $it")
    }

    solution(
            arrayOf("TR", "RT", "TR"),
            intArrayOf(7, 1, 3)
    ).let {
        println("1. answer= $it")
    }


}
