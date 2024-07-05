class Solution {
    fun solution(n: Int, k: Int): IntArray {
        var answer = mutableListOf<Int>()
        for(num in 1 .. n){
            if(num %k == 0){
                answer.add(num)
            }
        }
        return answer.toIntArray()
    }
}