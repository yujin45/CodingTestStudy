class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        // 다른 사람 코드: 누적합 이용 n 넘지 않을 때까지 더하기
        return numbers.fold(0) { acc, i -> if (n >= acc) acc + i else acc }
        
        var answer: Int = 0
        for(num in numbers){
            answer += num
            if(answer > n){
                return answer
            }
        }
        return answer
    }
}