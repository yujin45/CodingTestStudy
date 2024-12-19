class Solution {
    fun solution(num_list: IntArray): Int {
        val odd = StringBuilder()
        val even = StringBuilder()
        
        for(num in num_list){
            if(num % 2 == 1){
                odd.append(num)        
            }else{
                even.append(num)
            }
        }
        
        return odd.toString().toInt() + even.toString().toInt()
    }
}
