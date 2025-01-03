class Solution {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()
        for(i in 0 until citations.size){
            if(citations[i] < (i+1)){
                return i
            }
        }
        return citations.size
    }
}