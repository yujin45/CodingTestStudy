package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val graph = Array(N) {
        br.readLine().map { it.digitToInt() }.toIntArray()
    }

    // 단지 번호 붙여서 단지 수
    val homeCountList = mutableListOf<Int>()
    for (i in graph.indices) {
        for (j in graph[0].indices) {
            if (graph[i][j] == 1) {
                homeCountList.add(dfs(graph, i, j))
            }
        }
    }

    homeCountList.sort()

    val sb = StringBuilder()
    sb.append(homeCountList.size).append("\n")
    homeCountList.forEach { sb.append(it).append("\n") }
    print(sb)

    br.close()
}

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Int {
    var count = 1
    graph[x][y] = 0

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 1) {
            count += dfs(graph, nx, ny)
        }
    }

    return count
}