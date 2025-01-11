package org.example


val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Int {
    var count = 1

    graph[x][y] = 1 // 방문 처리
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until graph.size && ny in 0 until graph[0].size && graph[nx][ny] == 0) {
            count += dfs(graph, nx, ny)
        }
    }
    return count
}

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m) { IntArray(n) }
    repeat(k) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        for (i in y1 until y2) {
            for (j in x1 until x2) {
                graph[i][j] = 1
            }
        }
    }

    val resultPlace = mutableListOf<Int>()
    for (i in 0 until graph.size) {
        for (j in 0 until graph[0].size) {
            if (graph[i][j] == 0) {
                resultPlace.add(dfs(graph, i, j))
            }
        }
    }
    resultPlace.sort()
    sb.append("${resultPlace.size}\n")
    for (r in resultPlace) {
        sb.append("${r} ")
    }
    println(sb)
    br.close()
}

