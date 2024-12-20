class Solution {
    fun solution(my_string: String, s: Int, e: Int): String {
        val charArray = my_string.toCharArray()
        var left = s
        var right = e
        while(left < right){
            val temp = charArray[left]
            charArray[left] = charArray[right]
            charArray[right] = temp
            left ++
            right --
        }
        return String(charArray)
    }
}