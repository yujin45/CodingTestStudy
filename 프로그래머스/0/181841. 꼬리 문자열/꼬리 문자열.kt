class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        val sb = StringBuilder()
        for(s in str_list){
            if(ex in s) continue
            sb.append(s)
        }
        return sb.toString()
    }
}