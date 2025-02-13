package org.example

import java.util.StringTokenizer

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (M, N) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N) { IntArray(M) }
    val queue = ArrayDeque<Pair<Int, Int>>() // BFS 큐

    var yetTomatoCount = 0
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            graph[i][j] = st.nextToken().toInt()
            if (graph[i][j] == 1) {
                queue.add(i to j) // 익은 토마토 큐에 미리 추가
            } else if (graph[i][j] == 0) {
                yetTomatoCount++ // 익지 않은 토마토 개수
            }
        }
    }
    // 입력 받았을 때부터 안 익은 것이 없다면 바로 0 출력 후 return
    if (yetTomatoCount == 0) {
        println(0)
        return
    }

    val result = bfs(graph, queue, yetTomatoCount)
    println(result) // 최소 날짜 출력
    br.close()

}

fun bfs(graph: Array<IntArray>, queue: ArrayDeque<Pair<Int, Int>>, yetTomatoCount: Int): Int {
    var days = -1 // 날짜 카운트(처음부터 1일 차이 발생하므로 -1 시작)
    var notDoneTomato = yetTomatoCount
    while (queue.isNotEmpty()) {
        val size = queue.size // 현재 날짜에 전파될 모든 토마토 개수
        for (i in 0 until size) {
            val (x, y) = queue.removeFirst()
            for (dir in 0 until 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]

                if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1 // 날짜 증가
                    queue.add(nx to ny) // 새로 익은 토마토를 큐에 추가
                    notDoneTomato--
                }
            }
        }
        days++ // 하루 증가
    }

    return if (notDoneTomato == 0) days else -1
}