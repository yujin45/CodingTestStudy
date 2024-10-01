class Solution {
    fun solution(dots: Array<IntArray>): Int {
        // 두 점 사이의 기울기를 계산하는 함수
        fun slope(dot1: IntArray, dot2: IntArray): Double {
            return (dot2[1] - dot1[1]).toDouble() / (dot2[0] - dot1[0]).toDouble()
        }

        // 가능한 직선 조합의 기울기를 비교
        return if (
            slope(dots[0], dots[1]) == slope(dots[2], dots[3]) || // (0,1) vs (2,3)
            slope(dots[0], dots[2]) == slope(dots[1], dots[3]) || // (0,2) vs (1,3)
            slope(dots[0], dots[3]) == slope(dots[1], dots[2])    // (0,3) vs (1,2)
        ) 1 else 0
    }
}
