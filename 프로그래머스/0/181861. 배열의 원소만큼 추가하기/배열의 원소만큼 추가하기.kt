class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val list = mutableListOf<Int>()
        for(a in arr){
            for(k in 0 until a){
                list.add(a)
            }
        }
        return list.toIntArray()
    }
}