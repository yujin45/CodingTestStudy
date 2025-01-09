package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    //
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = List(n) { br.readLine().map { it.digitToInt() }.toIntArray() }
//    graph.forEach{row ->
//        println(row.joinToString(" "))
//    }

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(0 to 0)
    graph[0][0]++
    // 방향
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        if (x == n - 1 && y == m - 1) {
            println(graph[x][y] - 1)
            break
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] == 1) {
                queue.add(nx to ny)
                graph[nx][ny] = graph[x][y] + 1
            }
        }

    }
    //
    br.close()
}
