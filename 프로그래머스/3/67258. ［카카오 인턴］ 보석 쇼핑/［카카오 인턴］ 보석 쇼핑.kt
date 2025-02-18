class Solution {
    fun solution(gems: Array<String>): IntArray {
        val kind = gems.toSet().size // 보석 종류 개수
        val gemCount = mutableMapOf<String, Int>() // 보석 개수를 저장할 해시맵
        var start = 0
        var end = 0
        var minLength = Int.MAX_VALUE
        var answer = intArrayOf(0, 0)

        while (end < gems.size) {
            // end 포인터 이동하며 보석 개수 추가
            gemCount[gems[end]] = gemCount.getOrDefault(gems[end], 0) + 1
            end++

            // 모든 종류를 포함한 경우, start를 이동하며 최소 구간 찾기
            while (gemCount.size == kind) {
                if (end - start < minLength) {
                    minLength = end - start
                    answer = intArrayOf(start + 1, end) // 진열대 번호로 변환 (1부터 시작)
                }
                
                // start 포인터를 이동하며 보석 개수 줄이기
                gemCount[gems[start]] = gemCount[gems[start]]!! - 1
                if (gemCount[gems[start]] == 0) gemCount.remove(gems[start]) // 개수가 0이 되면 제거
                start++
            }
        }

        return answer
    }
}
