class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((s, e) in queries){
            for(i in s..e){
                arr[i]++
            }
        }
        return arr
    }
}