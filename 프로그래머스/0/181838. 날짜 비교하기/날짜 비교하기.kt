import java.time.LocalDate

class Solution {
    fun solution(date1: IntArray, date2: IntArray): Int {
        val d1 = date1[0] * 10000 + date1[1] * 100 + date1[2]
        val d2 = date2[0] * 10000 + date2[1] * 100 + date2[2]
        return if ( d1<d2 ) 1 else 0
    }
}


class Solution2 {
    fun solution(date1: IntArray, date2: IntArray): Int {
        // LocalDate 객체 생성
        val d1 = LocalDate.of(date1[0], date1[1], date1[2])
        val d2 = LocalDate.of(date2[0], date2[1], date2[2])
        // d1이 d2보다 앞서는지 비교
        return if (d1.isBefore(d2)) 1 else 0
    }
}

/*
테스트 1 〉	통과 (0.89ms, 62.9MB)
테스트 2 〉	통과 (0.85ms, 63.4MB)
테스트 3 〉	통과 (1.21ms, 62.4MB)
테스트 4 〉	통과 (1.37ms, 62.3MB)
테스트 5 〉	통과 (1.14ms, 64.3MB)
테스트 6 〉	통과 (0.85ms, 62.8MB)
테스트 7 〉	통과 (0.85ms, 63MB)
테스트 8 〉	통과 (0.88ms, 63.3MB)
테스트 9 〉	통과 (1.32ms, 64.4MB)
테스트 10 〉	통과 (0.89ms, 64MB)
테스트 11 〉	통과 (1.07ms, 63.3MB)
테스트 12 〉	통과 (0.89ms, 62.9MB)
테스트 13 〉	통과 (0.95ms, 63.9MB)
테스트 14 〉	통과 (1.25ms, 64.4MB)
테스트 15 〉	통과 (0.88ms, 62.9MB)
*/