class Solution {
    fun solution(x: Int): Boolean {
        // x의 자릿수 합을 구함
        val digitSum = x.toString().map { it.toString().toInt() }.sum()
        // x가 자릿수 합으로 나누어 떨어지는지 확인
        return x % digitSum == 0
    }
}
