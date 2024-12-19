class Solution {
    fun solution(numLog: IntArray): String {
        // numLog[0] => when 작업 -> numLog
        val ret = StringBuilder()
        for(i in (0 until numLog.size-1)){
            var op = numLog[i+1] - numLog[i]
            when(op){
                1 -> ret.append("w")
                -1 -> ret.append("s")
                10 -> ret.append("d")
                -10 -> ret.append("a")
            }
        }
        return ret.toString()
    }
}