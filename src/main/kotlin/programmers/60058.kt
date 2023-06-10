package programmers

/*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
      3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
      4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
      4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
      4-3. ')'를 다시 붙입니다.
      4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
      4-5. 생성된 문자열을 반환합니다.
 */
private fun solution(p: String): String {
    return convertToGood(p)
}

private fun convertToGood(p: String): String {
    if (p.isEmpty()) return p
    val uv = splitToUV(p)
    return if (isGood(uv[0])) {
        uv[0] + convertToGood(uv[1])
    } else {
        var s = "("
        s += convertToGood(uv[1])
        s += ")"
        val uu = uv[0].drop(1).dropLast(1).fold(StringBuilder()) { acc, c ->
            acc.append(
                    if (c == '(') {
                        ")"
                    } else {
                        "("
                    }
            )
            acc
        }.toString()
        s += uu
        s
    }
}

private fun isGood(u: String): Boolean {
    var result = 0
    u.forEach {
        if (it == '(') {
            result++
        } else if (it == ')') {
            result--
        }
        if (result < 0) return false
    }

    return result == 0
}

private fun splitToUV(w: String): List<String> {
    var a = 0
    var b = 0
    w.forEachIndexed { index, c ->
        if (a != 0 && b != 0 && a == b) {
            return listOf(w.substring(0, index), w.substring(index))
        }

        if (c == '(') a++
        if (c == ')') b++
    }
    return listOf(w, "")
}

fun main() {
    val list = listOf(
            "()))((()"
    )

    list.forEach {
        println(solution(it))
    }
}
