class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val len = if(num_list.size % n == 0){
            num_list.size / n
        }else{
            num_list.size /n + 1
        }
        return IntArray(len){num_list[it*n]}
    }
}