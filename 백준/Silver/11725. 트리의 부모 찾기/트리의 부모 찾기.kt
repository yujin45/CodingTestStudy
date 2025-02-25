package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    // 루트 없는 트리 루트 1로 가정, 각 노드의 부모
    val N = br.readLine().toInt()
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = IntArray(N + 1)
    visited[1] = -1 //루트 표시
    dfs(graph, 1, visited)

    val sb = StringBuilder()
    for (i in 2..N) {
        sb.append(visited[i]).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: IntArray) {
    for (neighbor in graph[v]) {
        if (visited[neighbor] == 0) {
            // 방문 전이면
            visited[neighbor] = v // 부모 넣어주고 다음 진행
            dfs(graph, neighbor, visited)
        }
    }
}