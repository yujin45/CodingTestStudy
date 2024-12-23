class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        val arrSize  = arr.size
        if(arrSize %2 == 1){
            for(i in arr.indices step 2){
                arr[i] += n
            }
        }else{
            for(i in 1 until arr.size step 2){
                arr[i] += n
            }
        }
        return arr
    }
}