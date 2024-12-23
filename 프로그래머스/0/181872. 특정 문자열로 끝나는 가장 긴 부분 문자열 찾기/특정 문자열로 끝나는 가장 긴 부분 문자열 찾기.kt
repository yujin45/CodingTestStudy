class Solution {
    fun solution(myString: String, pat: String): String {
        var answer: String = ""
        return myString.substringBeforeLast(pat) + pat
    }
}

class Solution3 {
    fun solution(myString: String, pat: String): String {
        val index = myString.lastIndexOf(pat)
        return myString.substring(0, index + pat.length)
    }
}

/*
테스트 1 〉	통과 (8.33ms, 63.9MB)
테스트 2 〉	통과 (7.03ms, 65.8MB)
테스트 3 〉	통과 (8.20ms, 64.1MB)
테스트 4 〉	통과 (8.43ms, 63.9MB)
테스트 5 〉	통과 (9.45ms, 64MB)
테스트 6 〉	통과 (6.77ms, 63.9MB)
테스트 7 〉	통과 (7.02ms, 64.1MB)
테스트 8 〉	통과 (7.17ms, 63.5MB)
테스트 9 〉	통과 (6.99ms, 64.7MB)
테스트 10 〉	통과 (7.13ms, 64.1MB)
테스트 11 〉	통과 (6.72ms, 64.2MB)
테스트 12 〉	통과 (6.85ms, 64.2MB)
*/