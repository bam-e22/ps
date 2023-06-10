package leet


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var res = 0
        while (right < s.length) {
            val r = s[right]
            chars[r] = chars.getOrDefault(r, 0) + 1
            while (chars[r]!! > 1) {
                val l = s[left]
                chars[l] = chars[l]!! - 1
                left++
            }
            res = Math.max(res, right - left + 1)
            right++
        }
        return res
    }
}

fun main() {
    val s = Solution()
    println(s.lengthOfLongestSubstring("abcabcbb"))
    println(s.lengthOfLongestSubstring("bbbbb"))
    println(s.lengthOfLongestSubstring("pwwkew"))

}
