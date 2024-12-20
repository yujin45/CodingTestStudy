class Solution {
    fun solution(q: Int, r: Int, code: String): String {
        val sb = StringBuilder()
        for(i in code.indices){
            if(i%q == r){
                sb.append(code[i])
            }
        }
        return sb.toString()
    }
}