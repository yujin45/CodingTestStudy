class Solution1 {
    fun solution(phone_number: String): String {
        val starLen =  phone_number.length - 4
        val star = "*".repeat(starLen)
        
        return star + phone_number.substring(starLen, phone_number.length) 
    }
}

class Solution {
    fun solution(phone_number: String): String {
        val hidden = "*".repeat(phone_number.length - 4)  // 앞 부분은 *로 대체
        val lastFour = phone_number.takeLast(4)  // 마지막 4자리만 가져옴
        return hidden + lastFour
    }
}