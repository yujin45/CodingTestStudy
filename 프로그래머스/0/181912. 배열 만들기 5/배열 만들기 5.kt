class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        return intStrs.mapNotNull{
            val num = it.substring(s, s+l).toInt()
            if(num > k ) num else null
        }.toIntArray()
    }
}