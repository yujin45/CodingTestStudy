package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    val distances = IntArray(N + 1) { -1 } // 거리 배열(-1 방문X)
    val queue = ArrayDeque<Int>()

    distances[1] = 0 // 시작점 1번 헛간
    queue.addLast(1) // 1번 헛간

    var maxDistance = 0 // 가장 먼 거리
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        for (neighbor in graph[node]) {
            if (distances[neighbor] == -1) {
                // 방문하지 않은 경우
                distances[neighbor] = distances[node] + 1 //깊이 확장
                maxDistance = maxOf(maxDistance, distances[neighbor])
                queue.addLast(neighbor)
            }
        }
    }

    // 가장 먼 헛간 착지
    var hideNum = -1
    var count = 0
    for (i in 1..N) {
        if (distances[i] == maxDistance) {
            if (hideNum == -1) hideNum = i // 가장 작은 번호 선택
            count++
        }
    }
    println("$hideNum $maxDistance $count")
    br.close()
}
