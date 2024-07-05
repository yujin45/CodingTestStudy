class Solution {
    fun solution(myString: String, pat: String): Int {
        // 대소문자를 구분하지 않음이 포인트!
        var lowerMyString = myString.lowercase()
        var lowerPat = pat.lowercase()
        return if(lowerPat in lowerMyString) 1 else 0
    }
}