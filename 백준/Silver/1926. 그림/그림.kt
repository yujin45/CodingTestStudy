package org.example

private val directions = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1),
)

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Int {
    graph[x][y] = 2
    var count = 1
    for ((dx, dy) in directions) {
        val nx = x + dx
        val ny = y + dy
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 1) {
            count += dfs(graph, nx, ny)
        }
    }
    return count
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var resultMax = 0
    var resultCount = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                resultMax = maxOf(dfs(graph, i, j), resultMax)
                resultCount++
            }
        }
    }
    println("${resultCount}\n${resultMax}")

    br.close()
}