package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

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

    val distances = IntArray(N + 1) { -1 }// 거리 배열(-1은 방문X)
    val queue = ArrayDeque<Int>()

    distances[1] = 0 // 시작점 1번 헛간
    queue.addLast(1)

    var maxDistance = 0
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        for (neighbor in graph[node]) {
            if (distances[neighbor] == -1) {
                // 방문 전일 때
                distances[neighbor] = distances[node] + 1 // 현재에서 길이 확장
                maxDistance = maxOf(maxDistance, distances[neighbor])
                queue.addLast(neighbor)
            }
        }
    }

    // 가장 먼 헛간 찾기
    var hideNum = -1
    var count = 0
    for (i in 1..N) {
        if (distances[i] == maxDistance) {
            if (hideNum == -1) hideNum = i // 가장 작은 번호 선택
            count++
        }
    }
    val sb = StringBuilder()
    sb.append(hideNum).append(" ").append(maxDistance).append(" ").append(count)
    println(sb)
    br.close()
}

