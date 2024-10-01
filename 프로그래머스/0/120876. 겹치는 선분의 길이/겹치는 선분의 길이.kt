class Solution {
    fun solution(lines: Array<IntArray>): Int {
        // -100 <= a < b <= 100 이므로, 총 201개의 배열로 범위 설정
        val linePoints = IntArray(201)

        // 각 선분의 구간에 대해 값을 더해줌 (끝점은 포함하지 않음)
        for (line in lines) {
            val start = line[0] + 100  // 음수를 처리하기 위해 100을 더해줌
            val end = line[1] + 100

            for (i in start until end) {
                linePoints[i]++
            }
        }

        // 두 개 이상의 선분이 겹치는 구간의 길이 계산
        var overlapLength = 0
        for (count in linePoints) {
            if (count > 1) {
                overlapLength++
            }
        }

        return overlapLength
    }
}
