package org.example

private val directions = arrayOf(
    intArrayOf(-1, -1),
    intArrayOf(-1, 0),
    intArrayOf(-1, 1),
    intArrayOf(0, -1),
    intArrayOf(0, 1),
    intArrayOf(1, -1),
    intArrayOf(1, 0),
    intArrayOf(1, 1),
)

fun dfs(graph: Array<IntArray>, x: Int, y: Int) {
    graph[x][y] = 2 // 방문 표시
    for ((dx, dy) in directions) {
        val nx = x + dx
        val ny = y + dy
        if (nx in 0 until graph.size && ny in 0 until graph[0].size && graph[nx][ny] == 1) {
            dfs(graph, nx, ny)
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var count = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (graph[i][j] == 1) {
                dfs(graph, i, j)
                count++
            }
        }
    }
    println(count)
    br.close()
}