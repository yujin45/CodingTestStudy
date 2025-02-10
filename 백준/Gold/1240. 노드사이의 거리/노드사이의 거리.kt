package org.example


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
        val visited = BooleanArray(N + 1)
        sb.append(dfs(graph, p1, p2, visited, 0)).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Pair<Int, Int>>>, v: Int, target: Int, visited: BooleanArray, dist: Int): Int {
    visited[v] = true
    if (v == target) {
        return dist
    }
    for ((neighbor, cost) in graph[v]) {
        if (!visited[neighbor]) {
            val ret = dfs(graph, neighbor, target, visited, dist + cost)
            if (ret != -1) return ret
        }
    }

    return -1
}
