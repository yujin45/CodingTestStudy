class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        // 다른 사람 풀이
        return num_list.filterIndexed { index, _ -> index % n == 0 }.toIntArray()
        // 내 풀이
        return num_list.toList().chunked(n).map{it.first()}.toIntArray()
    }
}