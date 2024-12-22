class Solution {
    fun solution(num_list: IntArray): Int {
        if(num_list.size >= 11){
            return num_list.sum()
        }else{
            var mu = 1
            for(n in num_list){
                mu *=n
            }
            return mu
        }
        return -1
    }
}