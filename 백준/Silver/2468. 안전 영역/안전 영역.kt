package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

// 일정 높이 이하의 모든 지점은 물에 잠긴다.
// 안전영역의 개수 중 최대 구하기
fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val graphOrigin = Array(N) { IntArray(N) }
    var maxHeight = Int.MIN_VALUE
    var minHeight = Int.MAX_VALUE
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            val h = st.nextToken().toInt()
            maxHeight = maxOf(maxHeight, h)
            minHeight = minOf(minHeight, h)
            graphOrigin[i][j] = h
        }
    }

    // 높이가 min ~ max인 상태
    var result = 1 // 아무 영역도 물에 잠기지 않을 수 있다..
    for (h in minHeight..maxHeight) {
        val graph = Array(graphOrigin.size) { idx ->
            graphOrigin[idx].copyOf()
        }
        var count = 0
        for (i in graph.indices) {
            for (j in graph[0].indices) {
                if (graph[i][j] > h) {
                    // 안전 영역일 때
                    dfs(graph, i, j, h)
                    count++
                }
            }
        }
        result = maxOf(result, count)
    }

    println(result)

    br.close()
}

fun dfs(graph: Array<IntArray>, x: Int, y: Int, h: Int) {
    graph[x][y] = -1 // 방문 표시
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] > h) {
            dfs(graph, nx, ny, h)
        }
    }
}