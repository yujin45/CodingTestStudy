class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        var result = arr.copyOf()
        
        if(arr.size %2 ==1 ){
            for(i in result.indices step 2){
                result[i] += n
            }
        }else{
            for(i in 1 until result.size step 2){
                result[i] += n
            }
        }
        return result
    }
}