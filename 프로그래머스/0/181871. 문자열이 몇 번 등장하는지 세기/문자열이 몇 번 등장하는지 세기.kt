class Solution {
    fun solution(myString: String, pat: String): Int {
        var count = 0
        var startIndex = 0

        while (startIndex <= myString.length - pat.length) {
            if (myString.substring(startIndex, startIndex + pat.length) == pat) {
                count++
            }
            startIndex++ // 한 칸씩 이동 (겹치는 경우 포함)
        }

        return count
    }
}
