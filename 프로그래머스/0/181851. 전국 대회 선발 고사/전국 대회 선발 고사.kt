class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val candidates = rank
        .withIndex()
        .filter{attendance[it.index]}
        .sortedBy{it.value}
        
        val (a, b, c) = candidates.take(3).map{it.index}
        return 10000 * a + 100 * b + c
    }
}