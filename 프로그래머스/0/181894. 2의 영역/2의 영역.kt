class Solution {
    fun solution(arr: IntArray): IntArray {
        var start = -1
        var end = -1
        for(i in 0 until arr.size){
            if(arr[i] == 2){
                start = i
                break
            } 
        }
        
        if(start == -1) return intArrayOf(-1)
        
        for(i in (arr.size -1) downTo 0){
            if(arr[i] == 2){
                end = i
                break
            } 
        }
        
        
        return IntArray(end - start + 1){arr[it + start]}
    }
}