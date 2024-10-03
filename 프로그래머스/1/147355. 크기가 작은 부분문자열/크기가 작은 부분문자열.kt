class Solution {
    fun solution(t: String, p: String): Int {
        var count = 0
        val pValue = p.toLong()  // p를 Long 타입으로 변환
        for (i in 0..(t.length - p.length)) {
            val sub = t.substring(i, i + p.length).toLong()  // 부분 문자열을 Long 타입으로 변환
            if (sub <= pValue) {
                count++
            }
        }
        return count
    }
}
