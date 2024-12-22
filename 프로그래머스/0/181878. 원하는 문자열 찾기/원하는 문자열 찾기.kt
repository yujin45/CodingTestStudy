class Solution {
    fun solution(myString: String, pat: String): Int {
        return if(myString.contains(pat, true)) 1 else 0
    }
}