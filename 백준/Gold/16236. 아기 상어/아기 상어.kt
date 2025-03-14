package org.example

import java.util.StringTokenizer

data class Shark(var x: Int, var y: Int, var size: Int, var eaten: Int)
data class Point(var x: Int, var y: Int, var dist: Int)

// 상, 좌, 우, 하
private val dx = intArrayOf(-1, 0, 0, 1) // 상, 좌, 우, 하
private val dy = intArrayOf(0, -1, 1, 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var fishCount = 0
    val graph = Array(N) { IntArray(N) }
    var shark = Shark(0, 0, 2, 0)

    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            val block = st.nextToken().toInt()
            if (block in (1..6)) {
                fishCount++
                graph[i][j] = block
            } else if (block == 9) {
                shark = Shark(i, j, 2, 0)
                graph[i][j] = 0 // 아기상어 위치 확인 완료로 초기화 
            } else {
                graph[i][j] = block
            }
        }
    }

    if (fishCount == 0) {
        // 물고기가 처음부터 없으면 바로 0 리턴
        println(0)
        return
    }

    var totalTime = 0

    while (true) {
        val result = bfs(graph, shark, N)
        if (result == null) break // 먹을 물고기가 없으면 종료

        val (nx, ny, dist) = result
        totalTime += dist
        shark.x = nx
        shark.y = ny
        shark.eaten++

        if (shark.eaten == shark.size) {
            shark.size++
            shark.eaten = 0
        }

        graph[nx][ny] = 0 // 먹은 위치 빈칸으로 만들기
    }

    println(totalTime)


    br.close()
}


fun bfs(graph: Array<IntArray>, shark: Shark, N: Int): Point? {
    val queue = ArrayDeque<Point>()
    val visited = Array(N) { BooleanArray(N) }
    queue.add(Point(shark.x, shark.y, 0))
    visited[shark.x][shark.y] = true

    val fishList = mutableListOf<Point>() //(x, y, 거리)

    while (queue.isNotEmpty()) {
        val (x, y, dist) = queue.removeFirst()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny]) {
                if (graph[nx][ny] <= shark.size) {
                    // 이동 가능(빈칸 or 먹을 수 있는 크기)
                    visited[nx][ny] = true
                    queue.add(Point(nx, ny, dist + 1))

                    if (graph[nx][ny] in 1 until shark.size) {
                        // 먹을 수 있는 크기라면
                        fishList.add(Point(nx, ny, dist + 1))
                    }
                }
            }
        }
    }
    // 거리 - 상 - 좌 순서
    return fishList.minWithOrNull(compareBy<Point> { it.dist }.thenBy { it.x }.thenBy { it.y })
}
