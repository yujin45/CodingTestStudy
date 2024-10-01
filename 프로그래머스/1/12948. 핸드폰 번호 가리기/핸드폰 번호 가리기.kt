class Solution {
    fun solution(phone_number: String): String {
        val starLen =  phone_number.length - 4
        val star = "*".repeat(starLen)
        
        return star + phone_number.substring(starLen, phone_number.length) 
    }
}