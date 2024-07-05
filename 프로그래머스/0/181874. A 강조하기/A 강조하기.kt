class Solution {
    fun solution(myString: String): String {
        // a만 대문자로 아닌 것은 소문자로 
        // 1 전체를 소문자로 변환
        // 2 a만 대문자로 변환
        return myString.lowercase().replace("a", "A")
    }
}