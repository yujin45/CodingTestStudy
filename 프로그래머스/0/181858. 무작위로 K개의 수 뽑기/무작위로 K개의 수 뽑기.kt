class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        var ret: IntArray = IntArray(k){ -1 }
        val arrDis = arr.distinct()
        println(arrDis.indices)
        for(i in arrDis.indices){
            if(i == ret.size) break
            ret[i] = arrDis[i]
        }
        return ret
    }
}