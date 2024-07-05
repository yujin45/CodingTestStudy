class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        // filter 이용 방법
        return arr.filter{it !in delete_list}.toIntArray()
        // for루프 이용한 방법
        val result = mutableListOf<Int>()
        for (num in arr){
            if(num !in delete_list){
                result.add(num)
            }
        }
        return result.toIntArray()
    }
}