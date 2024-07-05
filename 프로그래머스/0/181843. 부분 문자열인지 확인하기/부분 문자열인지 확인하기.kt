class Solution {
    fun solution(my_string: String, target: String): Int {
        return if(target in my_string) 1 else 0
    }
}