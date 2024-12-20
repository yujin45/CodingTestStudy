
class Solution {
    fun solution(my_string: String): Array<String> {
        return Array(my_string.length){my_string.substring(it)}
        .sorted()
        .toTypedArray()
        
    }
}