class Solution {
    fun solution(n: Int): Array<IntArray> {
        val ret = Array(n){IntArray(n){0}}
        for(i in 0 until n){
            for(j in 0 until n){
                if(i==j) ret[i][j] = 1
            }
        }
        return ret
    }
}