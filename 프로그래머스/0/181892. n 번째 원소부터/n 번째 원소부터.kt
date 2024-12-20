class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return IntArray(num_list.size - n+1){ num_list[it + n -1] }
    }
}