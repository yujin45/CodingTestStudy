class Solution {
    fun solution(str1: String, str2: String): String {
        val result = StringBuilder()
        for(i in str1.indices){
            result.append(str1[i])
            result.append(str2[i])
        }
        return result.toString()
    }
}