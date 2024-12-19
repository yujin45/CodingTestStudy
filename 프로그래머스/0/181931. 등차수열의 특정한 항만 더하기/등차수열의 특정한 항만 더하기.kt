class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var ret : Int = 0
        for(i in included.indices){
            if(included[i]){
                ret += (a + d * i)
            }
        }
        return ret
    }
}