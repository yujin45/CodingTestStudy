class Solution1 {
    fun solution(n: Int): Int {
    
        return n.toString().map{ it.toString().toInt()}.sum()
    }
}

class Solution {
    fun solution(N: Int): Int {
        var sum = 0
        var number = N
        
        while (number > 0) {
            sum += number % 10  // 마지막 자릿수를 더함
            number /= 10        // 마지막 자릿수를 제거
        }
        
        return sum
    }
}
