package programmers

//https://school.programmers.co.kr/learn/courses/30/lessons/81302#fnref1]


fun main() {
    val arr = arrayOf(
            arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
            arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
            arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )
    solution(arr).let {
        println(it.contentToString())
    }
}


private fun solution(places: Array<Array<String>>): IntArray {
    return places.map { place ->
        check(place)
    }.toIntArray()
}

private fun check(place: Array<String>): Int {
    place.forEachIndexed { y, s ->
        s.forEachIndexed { x, c ->
            if (c == 'P') {
                if (!right(place, x, y)) return 0
                if (!rightright(place, x, y)) return 0
                if (!left(place, x, y)) return 0
                if (!leftleft(place, x, y)) return 0

                if (!up(place, x, y)) return 0
                if (!upup(place, x, y)) return 0

                if (!down(place, x, y)) return 0
                if (!downdown(place, x, y)) return 0

                if (!rightDown(place, x, y)) return 0
                if (!leftDown(place, x, y)) return 0
                if (!rightUp(place, x, y)) return 0
                if (!leftUp(place, x, y)) return 0
            }
        }
    }
    return 1
}

private fun right(place: Array<String>, x: Int, y: Int): Boolean {
    if (x + 1 >= 5) return true
    return place[y][x + 1] != 'P'
}

private fun left(place: Array<String>, x: Int, y: Int): Boolean {
    if (x - 1 < 0) return true
    return place[y][x - 1] != 'P'
}

private fun up(place: Array<String>, x: Int, y: Int): Boolean {
    if (y - 1 < 0) return true
    return place[y - 1][x] != 'P'
}

private fun down(place: Array<String>, x: Int, y: Int): Boolean {
    if (y + 1 >= 5) return true
    return place[y + 1][x] != 'P'
}

private fun rightright(place: Array<String>, x: Int, y: Int): Boolean {
    if (x + 2 >= 5) return true
    return place[y][x + 1] == 'X' || place[y][x + 2] != 'P'
}

private fun leftleft(place: Array<String>, x: Int, y: Int): Boolean {
    if (x - 2 < 0) return true
    return place[y][x - 1] == 'X' || place[y][x - 2] != 'P'
}

private fun upup(place: Array<String>, x: Int, y: Int): Boolean {
    if (y - 2 < 0) return true
    return place[y - 1][x] == 'X' || place[y - 2][x] != 'P'
}

private fun downdown(place: Array<String>, x: Int, y: Int): Boolean {
    if (y + 2 >= 5) return true
    return place[y + 1][x] == 'X' || place[y + 2][x] != 'P'
}

private fun rightDown(place: Array<String>, x: Int, y: Int): Boolean {
    if (x + 1 >= 5 || y + 1 >= 5) return true
    return place[y + 1][x + 1] != 'P' || (place[y][x + 1] == 'X' && place[y + 1][x] == 'X')
}

private fun rightUp(place: Array<String>, x: Int, y: Int): Boolean {
    if (x + 1 >= 5 || y - 1 < 0) return true
    return place[y - 1][x + 1] != 'P' || (place[y][x + 1] == 'X' && place[y - 1][x] == 'X')
}

private fun leftDown(place: Array<String>, x: Int, y: Int): Boolean {
    if (x - 1 < 0 || y + 1 >= 5) return true
    return place[y + 1][x - 1] != 'P' || (place[y][x - 1] == 'X' && place[y + 1][x] == 'X')
}

private fun leftUp(place: Array<String>, x: Int, y: Int): Boolean {
    if (x - 1 < 0 || y - 1 < 0) return true
    return place[y - 1][x - 1] != 'P' || (place[y][x - 1] == 'X' && place[y - 1][x] == 'X')
}
