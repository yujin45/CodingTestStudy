class Solution {
    fun solution(num_list: IntArray): Int {
        val product = num_list.reduce{acc, num -> acc * num} // 모든 원소의 곱
        val sumSquare = num_list.sum().let{it*it}
        return if(product < sumSquare) 1 else 0
    }
}