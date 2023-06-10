class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val cache = mutableMapOf<Int, Int>() // <match, index>
        nums.forEachIndexed { i, num ->
            if (cache.containsKey(num)) {
                return@twoSum intArrayOf(cache[num]!!, i)
            }
            cache[target - num] = i
        }
        return intArrayOf()
    }
}

fun main() {
    val s = Solution()
    s.twoSum(intArrayOf(2, 7, 11, 15), 9)
}
