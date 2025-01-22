package org.example

fun dfs(graph: Array<CharArray>, x: Int, y: Int, direction: Array<Pair<Int, Int>>): Int {
    var count = 1
    graph[x][y] = 'X'
    for ((dx, dy) in direction) {
        val nx = x + dx
        val ny = y + dy
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == '.') {
            count += dfs(graph, nx, ny, direction)
        }
    }
    return count
}

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val graphW = Array(n) { br.readLine().toCharArray() }
    val graphH = Array(n) { graphW[it].copyOf() }
  
    val driectionW = arrayOf((0 to -1), (0 to 1))
    val directionH = arrayOf((-1 to 0), (1 to 0))
    var sleepW = 0
    var sleepH = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graphW[i][j] == '.') {
                if (dfs(graphW, i, j, driectionW) >= 2) {
                    sleepW += 1
                }
            }
            if (graphH[i][j] == '.') {
                if (dfs(graphH, i, j, directionH) >= 2) {
                    sleepH += 1
                }
            }

        }
    }

    println("$sleepW $sleepH")

    br.close()
}
