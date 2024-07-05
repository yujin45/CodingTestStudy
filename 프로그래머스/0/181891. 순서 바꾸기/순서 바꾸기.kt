class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        // 다른 사람 풀이
        return (num_list + num_list).copyOfRange(n, n + num_list.size)
        // 내 풀이
        return (num_list.slice(n until num_list.size) + num_list.slice(0 until n)).toIntArray()
    }
}