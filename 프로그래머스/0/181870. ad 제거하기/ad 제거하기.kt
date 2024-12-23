
class Solution {
    fun solution(strArr: Array<String>): Array<String> {
       return strArr.filter{ !it.contains("ad") }.toTypedArray()
    }
}
/*
테스트 1 〉	통과 (8.30ms, 64.9MB)
테스트 2 〉	통과 (10.24ms, 64MB)
테스트 3 〉	통과 (8.33ms, 65.4MB)
테스트 4 〉	통과 (8.75ms, 64.4MB)
테스트 5 〉	통과 (9.82ms, 62.8MB)
테스트 6 〉	통과 (8.38ms, 63.1MB)
테스트 7 〉	통과 (8.39ms, 64.5MB)
테스트 8 〉	통과 (7.60ms, 64.3MB)
테스트 9 〉	통과 (6.79ms, 64.9MB)
테스트 10 〉	통과 (7.80ms, 65MB)
테스트 11 〉	통과 (12.48ms, 63.6MB)
테스트 12 〉	통과 (7.80ms, 65.4MB)
테스트 13 〉	통과 (7.60ms, 63.1MB)
*/

class Solution2 {
    fun solution(strArr: Array<String>): Array<String> {
        val result = mutableListOf<String>()
        for (str in strArr) {
            if (!str.contains("ad")) {
                result.add(str)
            }
        }
        return result.toTypedArray()
    }
}
