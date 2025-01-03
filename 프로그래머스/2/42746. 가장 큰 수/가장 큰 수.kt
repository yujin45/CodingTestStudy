class Solution {
    fun solution(numbers: IntArray): String {
        // Step 1: 숫자를 문자열로 변환
        val strNumbers = numbers.map { it.toString() }

        // Step 2: 문자열을 3번 반복해 정렬 기준 생성
        val sortedNumbers = strNumbers.sortedWith(compareByDescending { it.repeat(3) })

        // Step 3: 정렬된 문자열을 이어 붙임
        val result = sortedNumbers.joinToString("")

        // Step 4: 모든 숫자가 0일 경우 "0" 반환
        return if (result.startsWith("0")) "0" else result
    }
}
