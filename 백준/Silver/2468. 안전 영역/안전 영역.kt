package org.example

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun dfs(graph: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>, h: Int) {
    if (!(x in 0 until graph.size) || !(y in 0 until graph[0].size) || visited[x][y] || graph[x][y] <= h) {
        return
    }
    visited[x][y] = true
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        dfs(graph, nx, ny, visited, h)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val max_height = graph.flatMap { it.toList() }.max()
    //println("Min: $min_height, Max: $max_height")
    var ret = 1
    for (h in 1 until max_height) {
        val visited = Array(n) { BooleanArray(n) }
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j] && graph[i][j] > h) {
                    dfs(graph, i, j, visited, h)
                    count++
                    //println("h: $h - i : $i - j : $j - count : $count")
                }
            }
        }
        ret = maxOf(ret, count)
    }
    println("$ret")
    br.close()
}

