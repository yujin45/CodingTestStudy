class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (num in arr){
            if(num !in delete_list){
                result.add(num)
            }
        }
        return result.toIntArray()
    }
}