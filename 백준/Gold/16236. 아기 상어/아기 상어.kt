import java.util.*

data class Fish(val x: Int, val y: Int, val dist: Int) // 물고기 정보 (좌표, 거리)

val dx = intArrayOf(-1, 1, 0, 0) // 상하좌우 이동 방향
val dy = intArrayOf(0, 0, -1, 1)

fun bfs(grid: Array<IntArray>, n: Int, sharkSize: Int, startX: Int, startY: Int): Fish? {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList() // BFS 큐 (x, y, 거리)
    val visited = Array(n) { BooleanArray(n) } // 방문 체크 배열
    val fishList = mutableListOf<Fish>() // 먹을 수 있는 물고기 리스트

    queue.add(Triple(startX, startY, 0))
    visited[startX][startY] = true

    while (queue.isNotEmpty()) {
        val (x, y, dist) = queue.poll()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            // 맵 범위 안에 있고, 아직 방문하지 않은 경우
            if (nx in 0 until n && ny in 0 until n && !visited[nx][ny]) {
                if (grid[nx][ny] <= sharkSize) { // 현재 상어 크기보다 작거나 같은 경우 이동 가능
                    queue.add(Triple(nx, ny, dist + 1))
                    visited[nx][ny] = true

                    if (grid[nx][ny] in 1 until sharkSize) { // 먹을 수 있는 물고기라면 리스트에 추가
                        fishList.add(Fish(nx, ny, dist + 1))
                    }
                }
            }
        }
    }

    // 가장 가까운 물고기 찾기 (거리 -> x(위쪽) -> y(왼쪽) 순서로 정렬)
    return fishList.minWithOrNull(compareBy({ it.dist }, { it.x }, { it.y }))
}

fun main() {
    val n = readLine()!!.toInt()
    val grid = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    var sharkX = 0
    var sharkY = 0
    var sharkSize = 2 // 초기 상어 크기
    var eatCount = 0 // 먹은 물고기 수
    var totalTime = 0 // 총 걸린 시간

    // 아기 상어 위치 찾기
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 9) {
                sharkX = i
                sharkY = j
                grid[i][j] = 0 // 아기 상어 위치를 빈 칸(0)으로 변경
            }
        }
    }

    // 시뮬레이션 시작
    while (true) {
        val fish = bfs(grid, n, sharkSize, sharkX, sharkY) ?: break // 먹을 물고기 탐색, 없으면 종료

        // 가장 가까운 물고기로 이동
        totalTime += fish.dist
        sharkX = fish.x
        sharkY = fish.y
        grid[fish.x][fish.y] = 0 // 물고기 먹음

        // 물고기를 먹으면 카운트 증가
        eatCount++
        if (eatCount == sharkSize) { // 크기만큼 먹으면 상어 크기 증가
            sharkSize++
            eatCount = 0
        }
    }

    // 총 걸린 시간 출력
    println(totalTime)
}
