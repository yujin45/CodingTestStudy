class Solution {
    fun solution(my_string: String): Array<String> {
        return my_string.split(" ").filter { it.isNotEmpty() }.toTypedArray()
    }
}