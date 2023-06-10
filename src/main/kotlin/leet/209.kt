package leet

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var length = Int.MAX_VALUE
    var startIndex = 0
    var endIndex = 0
    var sum = nums[0]

    loop@ while(true) {
        if (endIndex >= nums.size) {
            break@loop
        }

        when {
            // equal to target: 정답 갱신
            sum == target -> {
                length = minOf(length, endIndex - startIndex + 1)

                sum -= nums[startIndex]
                startIndex++
                if (startIndex > endIndex) {
                    endIndex = startIndex
                }
            }
            sum < target -> {
                endIndex++
                if (endIndex >= nums.size) {
                    break@loop
                }
                sum += nums[endIndex]
            }
            // greater than: 정답 갱신
            else -> {
                length = minOf(length, endIndex - startIndex + 1)
                sum -= nums[startIndex]
                startIndex++
                if (startIndex > endIndex) {
                    endIndex = startIndex
                }
            }
        }
    }
    return if (length == Int.MAX_VALUE) 0 else length
}

/*
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var length = Int.MAX_VALUE
    for (r in 1 .. nums.size) {
        combination(nums.toTypedArray(), nums.size, r).forEach {
            if (it.sum() >= target) {
                println("sum= ${it.sum()}, target= $target, size= ${it.size}, list= $it")
                length = minOf(length, it.size)
            }
        }
    }
    return if (length == Int.MAX_VALUE) 0 else length
}
*/



private fun <T> combination(array: Array<T>, n: Int, r: Int): List<List<T>> {
    val list = mutableListOf<List<T>>()

    fun recusrionCombination(depth: Int = 0, index: Int = 0, resultArray: Array<T> = array.sliceArray(0 until r)) {
        if (depth == r) {
            list.add(resultArray.toList())
            return
        }
        for (arrayIndex in index until n) {
            resultArray[depth] = array[arrayIndex]
            recusrionCombination(depth + 1, arrayIndex + 1, resultArray)
        }
    }
    recusrionCombination()
    return list
}

fun main() {
    minSubArrayLen(4, intArrayOf(1, 4, 4)).let {
        println("1. $it")
    }
    minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1)).let {
        println("2. $it")
    }
    minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)).let {
        println("3. $it")
    }
    minSubArrayLen(11, intArrayOf(1,2,3,4,5)).let {
        println("4. $it")
    }
    minSubArrayLen(213, intArrayOf(12,28,83,4,25,26,25,2,25,25,25,12)).let {
        println("5. $it")
    }
}
