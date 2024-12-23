class Solution {
    fun solution(myString: String): String {
        val sb = StringBuilder()
        for(m in myString){
            if(m < 'l'){
                sb.append('l')
            }else{
                sb.append(m)
            }
        }
        return sb.toString()
    }
}