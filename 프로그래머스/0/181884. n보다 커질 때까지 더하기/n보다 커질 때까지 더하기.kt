class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var sum = 0
        for(i in 0 until numbers.size){
            sum += numbers[i]
            if(sum > n) return sum
        }
        return -1
    }
}