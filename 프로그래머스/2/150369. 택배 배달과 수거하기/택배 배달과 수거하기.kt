class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var remainDeliveries = 0  // 남은 배달 상자 개수
        var remainPickups = 0     // 남은 수거 상자 개수

        for (i in n - 1 downTo 0) {
            remainDeliveries += deliveries[i]  // 현재 위치에서 배달해야 할 상자 추가
            remainPickups += pickups[i]        // 현재 위치에서 수거해야 할 상자 추가

            while (remainDeliveries > 0 || remainPickups > 0) {
                // 가장 멀리 가야 하는 집까지 왕복
                answer += (i + 1) * 2L  

                // cap 만큼 배달/수거 수행
                remainDeliveries -= cap
                remainPickups -= cap
            }
        }
        return answer
    }
}
