class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val result = arr.filter { it % divisor == 0 }  // divisor로 나누어 떨어지는 요소 필터링
            .sorted()  // 오름차순으로 정렬
        return if (result.isEmpty()) intArrayOf(-1) else result.toIntArray()  // 비어있으면 [-1], 그렇지 않으면 결과 반환
    }
}
