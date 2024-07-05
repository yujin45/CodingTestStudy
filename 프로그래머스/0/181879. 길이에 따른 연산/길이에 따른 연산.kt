class Solution {
    fun solution(num_list: IntArray): Int {
        // 다른 사람 풀이
        return when {
            num_list.size > 10 -> num_list.sum()
            else -> num_list.fold(1) { acc, i -> acc*i }
        }
        
        
        // 내 풀이
        if(num_list.size >= 11){
            return num_list.sum()
        }else{
            var mul : Int = 1
            for(n in num_list){
                mul *= n
            }
            return mul
        }
    }
}