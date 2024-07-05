class Solution {
    fun solution(n: Int, k: Int): IntArray {
        // 다른 사람 코드
        return (k..n step k).toList().toIntArray()
        return (1..n).filter{ it % k == 0 }.toIntArray()
        // 내 코드
        var answer = mutableListOf<Int>()
        for(num in 1 .. n){
            if(num %k == 0){
                answer.add(num)
            }
        }
        return answer.toIntArray()
    }
}