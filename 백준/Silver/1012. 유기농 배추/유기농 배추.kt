package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val T = br.readLine().toInt()
    repeat(T) {
        val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(M) { BooleanArray(N) }
        repeat(K) {
            val st = StringTokenizer(br.readLine())
            graph[st.nextToken().toInt()][st.nextToken().toInt()] = true
        }
        var count = 0
        for (i in graph.indices) {
            for (j in graph[0].indices) {
                if (graph[i][j]) {
                    dfs(graph, i, j)
                    count++
                }
            }
        }
        sb.append(count).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<BooleanArray>, x: Int, y: Int) {
    graph[x][y] = false // 방문처리
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny]) {
            dfs(graph, nx, ny)
        }
    }
}