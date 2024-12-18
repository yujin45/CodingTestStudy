class Solution {
    fun solution(a: Int, b: Int): Int {
        val ab = "$a$b".toInt()
        val ba = "$b$a".toInt()
        val result = if(ab > ba) ab else ba
        return result
    }
}