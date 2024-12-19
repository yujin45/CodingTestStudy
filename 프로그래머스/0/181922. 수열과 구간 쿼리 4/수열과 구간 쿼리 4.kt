class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for((s, e, k) in queries){
            for(i in s..e){
                if(i%k==0) arr[i]+=1
            }
        }
        return arr
    }
}