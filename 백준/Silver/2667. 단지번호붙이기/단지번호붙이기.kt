package org.example

// 전역으로 두고 쓰려고 함
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
var count = 0
fun main() {
    val br = System.`in`.bufferedReader()
    //
    val n = br.readLine().toInt()
    val graph = List(n) { br.readLine().map { it.digitToInt() }.toMutableList() }
   
    val homeCount = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1) {
                homeCount.add(dfs(graph, i, j, n))
                count = 0
            }
        }
    }
    println(homeCount.size)
    homeCount.sort()
    println(homeCount.joinToString("\n"))

    //
    br.close()
}

fun dfs(graph: List<MutableList<Int>>, x: Int, y: Int, n: Int): Int {
    graph[x][y] = 2 // 방문 처리
    count++
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until n && ny in 0 until n && graph[nx][ny] == 1) {
            dfs(graph, nx, ny, n)
        }

    }
    return count
}
