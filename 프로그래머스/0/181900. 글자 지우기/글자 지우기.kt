class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        val sb = StringBuilder()
        
        val charArray = my_string.toCharArray()
        for(i in indices){
            charArray[i] = '-'
        }
        for(c in charArray){
            if(c == '-') continue
            sb.append(c)
        }
        
        return sb.toString()
    }
}