package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(M) { IntArray(N) }
    repeat(K) {
        val st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        for (i in x1 until x2) {
            for (j in y1 until y2) {
                //println("$i, $j")
                graph[i][j] = 1 // 네모 영역 표시
            }
        }
    }

    val areaCount = mutableListOf<Int>()
    for (i in graph.indices) {
        for (j in graph[0].indices) {
            if (graph[i][j] == 0) {
                areaCount.add(dfs(graph, i, j))
            }
        }
    }

    areaCount.sort()
    val sb = StringBuilder()
    sb.append(areaCount.size).append("\n")
    areaCount.forEach { sb.append(it).append(" ") }
    sb.deleteCharAt(sb.length - 1)
    println(sb)

    br.close()
}

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Int {
    var count = 1
    graph[x][y] = 2
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
            count += dfs(graph, nx, ny)
        }
    }
    return count
}
