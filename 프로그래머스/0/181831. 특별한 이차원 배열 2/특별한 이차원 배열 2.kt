class Solution {
    fun solution(arr: Array<IntArray>): Int {
        for(i in 0 until arr.size){
            for(j in (i+1) until arr.size){
                if(arr[i][j] != arr[j][i]){
                    return 0
                }
            }
        }
        return 1
    }
}