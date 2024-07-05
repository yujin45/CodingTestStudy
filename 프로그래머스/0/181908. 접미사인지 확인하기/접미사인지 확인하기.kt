class Solution {
    fun solution(my_string: String, is_suffix: String): Int {
        return if(my_string.endsWith(is_suffix)) 1 else 0
    }
}