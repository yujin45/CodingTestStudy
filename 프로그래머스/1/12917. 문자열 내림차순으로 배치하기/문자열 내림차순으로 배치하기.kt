class Solution {
    fun solution(s: String): String {
        // 문자를 내림차순으로 정렬하여 새로운 문자열로 반환
        return s.toCharArray().sortedDescending().joinToString("")
    }
}
