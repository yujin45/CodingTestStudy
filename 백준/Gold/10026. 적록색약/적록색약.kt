package org.example

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    // RGB - 빨초 / 파
    // 구역 수
    val N = br.readLine().toInt()
    val graph = Array(N) { br.readLine().toCharArray() }
    val graphRG = Array(N) { idx -> graph[idx].copyOf() }
    //
    var totalRGB = 0
    var totalRG = 0
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (graph[i][j] != '#') {
                dfs(graph, i, j, graph[i][j], graph[i][j])
                totalRGB++
            }
            if (graphRG[i][j] != '#') {
                if (graphRG[i][j] == 'B') {
                    dfs(graphRG, i, j, 'B', 'B')
                } else {
                    dfs(graphRG, i, j, 'R', 'G')
                }
                totalRG++
            }
        }
    }
    println("$totalRGB $totalRG")
    br.close()
}

fun dfs(graph: Array<CharArray>, x: Int, y: Int, target1: Char, target2: Char) {
    graph[x][y] = '#'
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && (graph[nx][ny] == target1 || graph[nx][ny] == target2)) {
            dfs(graph, nx, ny, target1, target2)
        }
    }
}