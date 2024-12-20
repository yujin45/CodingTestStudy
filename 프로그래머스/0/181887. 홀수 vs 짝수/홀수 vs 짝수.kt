class Solution {
    fun solution(num_list: IntArray): Int {
        var oddSum = 0
        var evenSum = 0
        for (i in num_list.indices) {
            if (i % 2 == 0) {
                oddSum += num_list[i]  // 홀수 번째 합
            } else {
                evenSum += num_list[i] // 짝수 번째 합
            }
        }
        return maxOf(oddSum, evenSum)
    }
}
