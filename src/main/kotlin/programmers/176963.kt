package programmers

fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val cache = mutableMapOf<String, Int>()
    return photo.map {
        it.sumOf { person ->
            val value = if (cache.containsKey(person)) {
                cache[person]!!
            } else {
                val i = name.indexOf(person)
                if (i != -1) {
                    val v = yearning[i]
                    cache[person] = v
                    v
                } else {
                    0
                }
            }
            value
        }
    }.toIntArray()
}

fun main() {
    val name = arrayOf("may", "kein", "kain", "radi")
    val yearning = intArrayOf(5, 10, 1, 3)
    val photo = arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni")
    )
    println(solution(name, yearning, photo).contentToString())
}
