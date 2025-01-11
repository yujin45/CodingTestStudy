package org.example


fun main() {

    // 전역으로 두고 쓰려고 함
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    fun dfs(graph: Array<IntArray>, x: Int, y: Int) {
        graph[x][y] = 2 // 방문처리
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 1) {
                //println("${graph.indices} ${graph[0].indices}")
                dfs(graph, nx, ny)
            }
        }
    }


    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()


    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }

        val graph = Array(n) { IntArray(m) }
        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            graph[y][x] = 1
        }

        var totalCount = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] == 1) {
                    totalCount++
                    dfs(graph, i, j)
                }
            }
        }
        sb.append("$totalCount\n")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()

}
