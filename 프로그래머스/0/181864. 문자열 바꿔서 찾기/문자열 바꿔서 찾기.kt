class Solution {
    fun solution(myString: String, pat: String): Int {
        val sb = StringBuilder()
        for(m in myString){
            when(m){
                'A' -> sb.append('B')
                'B' -> sb.append('A')
            }
        }
        return if(sb.toString().contains(pat)) 1 else 0
    }
}