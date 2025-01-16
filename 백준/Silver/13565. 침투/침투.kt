package org.example

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Boolean {
    if (x == graph.size - 1) {
        return true
    }
    graph[x][y] = 1

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
            if (dfs(graph, nx, ny)) {
                return true
            }
        }
    }
    return false
}

fun main() {
    val br = System.`in`.bufferedReader()

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m) { br.readLine().map { it.digitToInt() }.toIntArray() }

    for (j in 0 until n) {
        if (graph[0][j] == 0) {
            if (dfs(graph, 0, j)) {
                println("YES")
                return
            }
        }
    }
    println("NO")
    br.close()
}