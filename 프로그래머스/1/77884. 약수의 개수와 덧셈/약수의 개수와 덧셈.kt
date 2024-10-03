class Solution {
    fun solution(left: Int, right: Int): Int {
        var result = 0
        
        for (num in left..right) {
            if (isPerfectSquare(num)) {
                result -= num // 약수 개수가 홀수면 뺌
            } else {
                result += num // 약수 개수가 짝수면 더함
            }
        }
        
        return result
    }
    
    // 완전 제곱수인지 판별하는 함수
    fun isPerfectSquare(n: Int): Boolean {
        val sqrt = Math.sqrt(n.toDouble()).toInt()
        return sqrt * sqrt == n
    }
}






class Solution2 {
    
    private fun countDivisor(num : Int): Int{
        var count = 1
        for(i in 2..num){
            if(num%i ==0) count++
        }
        return count
    }
    
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(num in left..right){
            if( countDivisor(num) % 2 ==0 ) answer+=num 
            else answer-= num
        }
        return answer
    }
}