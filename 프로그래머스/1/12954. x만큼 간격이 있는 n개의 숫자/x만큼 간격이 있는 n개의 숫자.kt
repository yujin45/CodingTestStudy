class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = mutableListOf<Long>()
        var num : Long = 0
        var count = 0
        while(count < n){
            num += x
            answer.add(num)
            count++
        }
        
        return answer.toLongArray()
    }
}