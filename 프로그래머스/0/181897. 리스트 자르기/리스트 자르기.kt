class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val (a, b, c) = slicer
        // n에 따라 슬라이싱
        return when(n){
            1 -> num_list.slice(0..b).toIntArray()
            2 -> num_list.slice(a until num_list.size).toIntArray()
            3 -> num_list.slice(a..b).toIntArray()
            4 -> num_list.slice(a..b step c).toIntArray()
            else -> intArrayOf()
        }
    }
}