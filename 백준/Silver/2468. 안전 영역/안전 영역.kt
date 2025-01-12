package org.example


val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)

fun bfs(graph: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>, h: Int) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(x to y)
    visited[x][y] = true
    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.removeFirst()
        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]
            if (nx in 0 until graph.size && ny in 0 until graph[0].size && !visited[nx][ny] && graph[nx][ny] > h) {
                queue.add(nx to ny)
                visited[nx][ny] = true
            }
        }
    }
    queue.clear()
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val min_height = graph.flatMap { it.toList() }.min()
    val max_height = graph.flatMap { it.toList() }.max()
    //println("Min: $min_height, Max: $max_height")
    var ret = 0
    for (h in (min_height - 1) until max_height) {
        val visited = Array(n) { BooleanArray(n) }
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j] && graph[i][j] > h) {
                    bfs(graph, i, j, visited, h)
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

