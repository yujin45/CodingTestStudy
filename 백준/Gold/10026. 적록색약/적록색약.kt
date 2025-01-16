package org.example

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)


fun dfs(graph: Array<CharArray>, x: Int, y: Int, color: String, visited: Array<BooleanArray>) {
    visited[x][y] = true
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] in color && !visited[nx][ny]) {
            visited[nx][ny] = true
            dfs(graph, nx, ny, color, visited)
        }
    }

}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().toCharArray() }
    var visited = Array(n) { BooleanArray(n) }
    var normalCount = 0
    var rgCount = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                if (graph[i][j] == 'R') {
                    dfs(graph, i, j, "R", visited)
                } else if (graph[i][j] == 'G') {
                    dfs(graph, i, j, "G", visited)
                } else if (graph[i][j] == 'B') {
                    dfs(graph, i, j, "B", visited)
                }
                normalCount++
            }
        }
    }
    visited = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                if (graph[i][j] == 'B') {
                    dfs(graph, i, j, "B", visited)
                } else {
                    dfs(graph, i, j, "RG", visited)
                }
                rgCount++
            }
        }
    }
    println("$normalCount $rgCount")
}