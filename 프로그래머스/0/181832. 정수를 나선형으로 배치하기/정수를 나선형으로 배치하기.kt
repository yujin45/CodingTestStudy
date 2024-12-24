class Solution1 {
    fun solution(n: Int): Array<IntArray> {
        val map = Array<IntArray>(n){
            IntArray(n)
        }
        // 시계방향으로 방향 벡터 설정 후 벽에 막히면 or 이미 채워진 곳이면 방향전환
        val direction = listOf(
        Pair(0, 1), // →
        Pair(1, 0), // ↓ 
        Pair(0, -1),// ←
        Pair(-1, 0) // ↑
        )
        var directIndex = 0
        var cx = 0
        var cy = 0
        var count = 1
        while(count<(n*n+1)){
            map[cx][cy] = count
            count++
            var nx = cx + direction[directIndex].first
            var ny = cy + direction[directIndex].second
            if(nx >=0 && nx <n && ny>=0 && ny<n && map[nx][ny]==0){
                cx = nx
                cy = ny
            }else{
                // 방향 전환 - 이거는 장애물 없어서 또 검사는 안해주겠음
                directIndex=(directIndex+1)%4
                cx = cx + direction[directIndex].first
                cy = cy + direction[directIndex].second
            }
        }
        
        return map
    }
}


class Solution {
    fun solution(n: Int): Array<IntArray> {
        val map = Array(n) { IntArray(n) }
        val direction = arrayOf(
            intArrayOf(0, 1),  // →
            intArrayOf(1, 0),  // ↓
            intArrayOf(0, -1), // ←
            intArrayOf(-1, 0)  // ↑
        )
        
        var x = 0
        var y = 0
        var dir = 0
        for (count in 1..n * n) {
            map[x][y] = count
            val nx = x + direction[dir][0]
            val ny = y + direction[dir][1]

            // 방향 전환 조건: 범위 초과 또는 이미 방문한 경우
            if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] != 0) {
                dir = (dir + 1) % 4 // 방향 전환
            }
            x += direction[dir][0]
            y += direction[dir][1]
        }
        
        return map
    }
}
