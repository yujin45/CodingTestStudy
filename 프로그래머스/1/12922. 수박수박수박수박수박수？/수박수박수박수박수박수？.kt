class Solution {
    fun solution(n: Int): String {
        return "수박".repeat(n / 2) + if (n % 2 == 1) "수" else ""
    }
}



class Solution1 {
    fun solution(n: Int): String {
       val repeatCount = n / 2 
        var answer = "수박".repeat(repeatCount)
        if (n % 2 != 0) { 
            answer += "수"
        }
        return answer
    }
}