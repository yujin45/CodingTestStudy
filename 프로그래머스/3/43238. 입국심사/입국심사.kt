class Solution {
    fun solution(n: Int, times: IntArray): Long {
        // 이진탐색 범위 설정 : 최소시간 1분 ~ 최대시간 가장 느린 심사관이 n명 했을 때
        var left = 1L
        var right = n.toLong() * times.maxOrNull()!!
        //println(times.maxOrNull()!!)
        var answer = right // 초기값은 가장 오래 걸리는 것으로
        
        // 이진 탐색 수행
        while(left <= right){
            val mid = (left + right) /2
            // mid분 동안 각 심사위원 별로 mid/it명 심사 가능
            val count = times.sumOf{mid/it} // 현재 mid 시간 동안 심사할 수 있는 총 인원
            
            if(count >=n){
                answer = mid // 가능한 시간이므로 저장
                right = mid - 1 // 더 짧은 시간도 가능한지 확인
            }else{
                left = mid + 1 // 시간이 부족하므로 늘려야 함
            }
            
        }
        
        return answer
    }
}