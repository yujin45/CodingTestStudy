
class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val result = rank.mapIndexed { i, v -> i to v }
            .filter { attendance[it.first] }
            .sortedBy { it.second }
        return result[0].first * 10000 + result[1].first * 100 + result[2].first
    }
}

class Solution0 {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        // 참여 가능한 학생의 등수와 인덱스를 리스트에 저장
        val candidates = rank.indices
            .filter { attendance[it] } // 참석 가능한 학생만 필터링
            .sortedBy { rank[it] } // 등수 기준 오름차순 정렬

        // 상위 3명을 가져옴
        val a = candidates[0]
        val b = candidates[1]
        val c = candidates[2]

        // 결과 계산
        return 10000 * a + 100 * b + c
    }
}

/*
테스트 1 〉	통과 (26.25ms, 66.6MB)
테스트 2 〉	통과 (25.07ms, 66.1MB)
테스트 3 〉	통과 (25.94ms, 66.6MB)
테스트 4 〉	통과 (26.40ms, 66.9MB)
테스트 5 〉	통과 (27.42ms, 66.4MB)
테스트 6 〉	통과 (33.81ms, 66.9MB)
테스트 7 〉	통과 (23.94ms, 66.1MB)
테스트 8 〉	통과 (23.93ms, 66.8MB)
테스트 9 〉	통과 (23.37ms, 66.7MB)
테스트 10 〉	통과 (30.03ms, 66.6MB)
테스트 11 〉	통과 (22.70ms, 66.4MB)
테스트 12 〉	통과 (23.82ms, 66.7MB)
테스트 13 〉	통과 (37.49ms, 66.4MB)
테스트 14 〉	통과 (24.92ms, 67.3MB)
테스트 15 〉	통과 (24.81ms, 66.3MB)
테스트 16 〉	통과 (30.29ms, 66.6MB)
테스트 17 〉	통과 (26.58ms, 66.7MB)
테스트 18 〉	통과 (26.71ms, 66.2MB)
테스트 19 〉	통과 (24.44ms, 66.9MB)
*/

class Solution2 {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val candidates = rank
        .withIndex()
        .filter{attendance[it.index]}
        .sortedBy{it.value}
        
        val (a, b, c) = candidates.take(3).map{it.index}
        return 10000 * a + 100 * b + c
    }
}

/*
테스트 1 〉	통과 (29.26ms, 65.8MB)
테스트 2 〉	통과 (39.06ms, 66.4MB)
테스트 3 〉	통과 (26.31ms, 66.5MB)
테스트 4 〉	통과 (29.41ms, 66MB)
테스트 5 〉	통과 (32.42ms, 66MB)
테스트 6 〉	통과 (26.37ms, 66.8MB)
테스트 7 〉	통과 (34.17ms, 65.9MB)
테스트 8 〉	통과 (35.25ms, 67.6MB)
테스트 9 〉	통과 (26.94ms, 66.4MB)
테스트 10 〉	통과 (26.04ms, 66.4MB)
테스트 11 〉	통과 (24.82ms, 66.9MB)
테스트 12 〉	통과 (32.76ms, 65.8MB)
테스트 13 〉	통과 (23.27ms, 67.7MB)
테스트 14 〉	통과 (22.90ms, 66.7MB)
테스트 15 〉	통과 (23.01ms, 66.5MB)
테스트 16 〉	통과 (23.86ms, 66.4MB)
테스트 17 〉	통과 (27.81ms, 66.6MB)
테스트 18 〉	통과 (23.60ms, 66.4MB)
테스트 19 〉	통과 (25.02ms, 66.6MB)
*/