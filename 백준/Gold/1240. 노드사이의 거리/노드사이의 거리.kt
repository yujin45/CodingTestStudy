package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() } // 노드, 거리
    repeat(N - 1) {
        val (a, b, distance) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b to distance)
        graph[b].add(a to distance)
    }
    val sb = StringBuilder()
    repeat(M) {
        val (p1, p2) = br.readLine().split(" ").map { it.toInt() }
        sb.append(bfs(graph, p1, p2, N)).append("\n")
    }
    print(sb)
    br.close()
}

fun bfs(graph: Array<MutableList<Pair<Int, Int>>>, start: Int, target: Int, N: Int): Int {
    val visited = BooleanArray(N + 1)
    val queue = ArrayDeque<Pair<Int, Int>>() // 현재 노드, 거리
    queue.addLast(start to 0)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val (current, currentDistance) = queue.removeLast()
        if (current == target) {
            return currentDistance
        }
        for ((neighbor, distance) in graph[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.addLast(neighbor to (currentDistance + distance)) // 지금 거리에 더 가야 하는 거리
            }
        }
    }
    return -1 // 연결되지 않은 경우
}