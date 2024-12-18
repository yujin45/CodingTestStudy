class Solution {
    fun solution(a: Int, b: Int): Int {
        val ab = "$a$b".toInt()
        val ab2 = "${2*a*b}".toInt()
        val result = maxOf(ab, ab2)
        return result
    }
}