class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        val charList = my_string.toMutableList()
        
        for((s, e) in queries){
            charList.subList(s, e+1).reverse()
        }
        return charList.joinToString("")
    }
}