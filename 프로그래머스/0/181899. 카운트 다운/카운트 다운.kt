class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        return IntArray(start_num - end_num + 1){ it -> start_num - it}
    }
}