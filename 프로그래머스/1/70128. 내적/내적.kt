class Solution1 {
    fun solution(a: IntArray, b: IntArray): Int {
        var sum =0
        a.forEachIndexed{index, value ->
            sum+= value * b[index]
        }
        return sum
    }
}

class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.zip(b)  // 두 배열을 쌍으로 묶음
            .sumOf { (x, y) -> x * y }  // 각 쌍을 곱한 값을 모두 더함
    }
}
