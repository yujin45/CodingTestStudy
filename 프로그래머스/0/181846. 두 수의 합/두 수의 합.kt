import java.math.BigInteger

import java.math.*

class Solution {
    fun solution(a: String, b: String): String {
        return BigDecimal(a).plus(BigDecimal(b)).toString()
    }
}
class Solution2 {
    fun solution(a: String, b: String): String {
        return (BigInteger(a) + BigInteger(b)).toString()
    }
}

/*
테스트 1 〉	통과 (1.12ms, 60.7MB)
테스트 2 〉	통과 (2.39ms, 62.6MB)
테스트 3 〉	통과 (28.38ms, 62.5MB)
테스트 4 〉	통과 (81.74ms, 71MB)
테스트 5 〉	통과 (390.06ms, 96.6MB)
테스트 6 〉	통과 (1.12ms, 62.8MB)
테스트 7 〉	통과 (4.59ms, 63.7MB)
테스트 8 〉	통과 (32.37ms, 62.1MB)
테스트 9 〉	통과 (183.17ms, 77.2MB)
테스트 10 〉	통과 (224.81ms, 86.8MB)
테스트 11 〉	통과 (6.90ms, 62.7MB)
테스트 12 〉	통과 (19.66ms, 62.5MB)
테스트 13 〉	통과 (37.58ms, 62.5MB)
테스트 14 〉	통과 (41.95ms, 63.6MB)
테스트 15 〉	통과 (279.48ms, 88.8MB)
테스트 16 〉	통과 (96.03ms, 79.2MB)
테스트 17 〉	통과 (72.49ms, 70.8MB)
테스트 18 〉	통과 (34.97ms, 63.2MB)
테스트 19 〉	통과 (131.08ms, 81.1MB)
테스트 20 〉	통과 (291.65ms, 85.7MB)
테스트 21 〉	통과 (180.47ms, 85.2MB)
테스트 22 〉	통과 (330.62ms, 86.8MB)
테스트 23 〉	통과 (312.75ms, 87.9MB)
테스트 24 〉	통과 (295.60ms, 87.4MB)
테스트 25 〉	통과 (354.16ms, 88.5MB)
테스트 26 〉	통과 (560.26ms, 106MB)
테스트 27 〉	통과 (483.43ms, 81.9MB)
테스트 28 〉	통과 (581.38ms, 91.8MB)
테스트 29 〉	통과 (278.46ms, 103MB)
테스트 30 〉	통과 (409.63ms, 98.7MB)
테스트 31 〉	통과 (236.50ms, 83.9MB)
*/