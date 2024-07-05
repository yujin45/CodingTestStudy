class Solution {
    fun solution(arr: IntArray): IntArray {
        
        // 내가 푼거
        var answer = mutableListOf<Int>()
        for (a in arr){
            for(i in 0 .. a-1){
                answer.add(a)
            }
        }
        return answer.toIntArray()
    }
}