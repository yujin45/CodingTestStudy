class Solution {
    fun solution(l: Int, r: Int): IntArray {
        val result = (l..r).filter{num ->
            num.toString().all{ it == '0' || it == '5'}
        }
        return if(result.isEmpty()) intArrayOf(-1) else result.toIntArray()
    }
}