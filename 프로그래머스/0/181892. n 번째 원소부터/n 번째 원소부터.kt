class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return num_list.copyOfRange(n-1, num_list.size)
    }
}