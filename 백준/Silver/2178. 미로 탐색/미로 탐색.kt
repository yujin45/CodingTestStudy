package org.example

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N) {
        br.readLine().map { it.digitToInt() }.toIntArray()
    }
    println(bfs(graph, Point(0, 0), Point(N - 1, M - 1)))
    br.close()
}

fun bfs(graph: Array<IntArray>, point: Point, destination: Point): Int {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val queue = ArrayDeque<Point>()
    queue.addLast(point)

    while (queue.isNotEmpty()) {
        val currentPoint = queue.removeFirst()
        if (currentPoint.equals(destination)) {
            return graph[currentPoint.x][currentPoint.y]
        }
        for (i in 0 until 4) {
            val nx = currentPoint.x + dx[i]
            val ny = currentPoint.y + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 1) {
                queue.addLast(Point(nx, ny))
                graph[nx][ny] += graph[currentPoint.x][currentPoint.y]
            }
        }
    }
    return -1
}
