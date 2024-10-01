class Solution1 {
    fun solution(a: Int, b: Int): Long {
        val start = kotlin.math.min(a, b).toLong()
        val end = kotlin.math.max(a, b).toLong()
        return (start..end).sum()
    }
}

class Solution {
    fun solution(a: Int, b: Int): Long {
        val min = minOf(a, b)  // a와 b 중 작은 값
        val max = maxOf(a, b)  // a와 b 중 큰 값

        // min부터 max까지의 합을 계산
        return (min..max).sumOf { it.toLong() }
    }
}
