class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val ret = IntArray(num_list.size)
        for (i in num_list.indices) {
            if (i < n) {
                // 앞부분을 뒤로 이동
                ret[num_list.size - n + i] = num_list[i]
            } else {
                // 뒷부분을 앞으로 이동
                ret[i - n] = num_list[i]
            }
        }
        return ret
    }
}
