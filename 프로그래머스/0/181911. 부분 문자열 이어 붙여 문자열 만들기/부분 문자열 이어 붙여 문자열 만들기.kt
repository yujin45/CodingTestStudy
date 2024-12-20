class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        var answer: String = ""
        val sb = StringBuilder()
        for(i in my_strings.indices){
            val (s, e) = parts[i]
            sb.append(my_strings[i].substring(s, e+1))
        }
        return sb.toString()
    }
}