package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    // 정점 N, 루트 번호 R, 쿼리 개수 Q
    val (N, R, Q) = br.readLine().split(" ").map { it.toInt() }
    // 트리 간선 정보
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (U, V) = br.readLine().split(" ").map { it.toInt() }
        // 가중치와 방향성이 없는 트리
        graph[U].add(V)
        graph[V].add(U)
    }
    val dp = IntArray(N + 1)
    val visited = BooleanArray(N + 1)

    dfs(graph, R, visited, dp)
    val sb = StringBuilder()
    repeat(Q) {
        val U = br.readLine().toInt()
        sb.append(dp[U]).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, dp: IntArray): Int {
    visited[v] = true
    dp[v] = 1 // 현재 노드도 포함
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            dp[v] += dfs(graph, neighbor, visited, dp) // 자식 노드의 서브트리 크기 합산
        }
    }
    return dp[v] // 현재 노드의 서브트리 크기 반환
}
