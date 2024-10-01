class Solution {
    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val directions = listOf(
            -1 to -1, -1 to 0, -1 to 1,  // 상, 대각선
             0 to -1,          0 to 1,  // 좌, 우
             1 to -1,  1 to 0,  1 to 1   // 하, 대각선
        )
        
        // 지뢰의 주변을 위험지역으로 설정
        val dangerZone = Array(n) { BooleanArray(n) }
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 1) {
                    // 지뢰가 있는 칸
                    dangerZone[i][j] = true
                    
                    // 주변 8방향 탐색
                    for ((di, dj) in directions) {
                        val ni = i + di
                        val nj = j + dj
                        
                        if (ni in 0 until n && nj in 0 until n) {
                            dangerZone[ni][nj] = true
                        }
                    }
                }
            }
        }
        
        // 안전한 지역 계산
        var safeZoneCount = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!dangerZone[i][j]) {
                    safeZoneCount++
                }
            }
        }

        return safeZoneCount
    }
}
