class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var remainDeliveries = 0
        var remainPickups = 0
        for(i in n-1 downTo 0){
            // 배달 갔다가 수거해오면서 cap씩 가능
            remainDeliveries += deliveries[i] // 배달해야 할 것 추가
            remainPickups += pickups[i] // 수거해야 할 것 추가

            while(remainDeliveries > 0 || remainPickups >0){
                // 가장 멀리 가는 곳 왕복 
                answer+=(i+1) *2L
                // CAP만큼 진행
                remainDeliveries -=cap
                remainPickups -=cap
            }
        }

        return answer
    }
}