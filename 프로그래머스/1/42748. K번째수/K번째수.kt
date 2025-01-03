class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        for(c in commands){
            val (i, j, k) = c
            val sliced = array.slice(i - 1 until j).sorted()
            answer.add(sliced[k-1])
        }
        return answer.toIntArray()
    }
}