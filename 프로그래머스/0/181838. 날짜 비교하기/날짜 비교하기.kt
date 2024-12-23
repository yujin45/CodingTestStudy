import java.time.LocalDate

class Solution {
    fun solution(date1: IntArray, date2: IntArray): Int {
        // LocalDate 객체 생성
        val d1 = LocalDate.of(date1[0], date1[1], date1[2])
        val d2 = LocalDate.of(date2[0], date2[1], date2[2])
        // d1이 d2보다 앞서는지 비교
        return if (d1.isBefore(d2)) 1 else 0
    }
}