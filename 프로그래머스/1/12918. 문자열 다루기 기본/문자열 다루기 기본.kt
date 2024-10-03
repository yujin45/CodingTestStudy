class Solution {
    fun solution(s: String): Boolean {
        // 길이가 4 또는 6이어야 하고, 모든 문자가 숫자여야 함
        return (s.length == 4 || s.length == 6) && s.all { it.isDigit() }
    }
}
