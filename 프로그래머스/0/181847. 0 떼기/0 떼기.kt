class Solution {
    fun solution(n_str: String): String {
        if(n_str[0]!='0') return n_str
        var flag = true
        val sb = StringBuilder()
        for(n in n_str){
            if(n != '0') flag = false
            if(flag) continue
            sb.append(n)
        }
        
        return sb.toString()
    }
}