package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    // dfs. bfs 탐색 결과 출력
    // 번호 작은 것 먼저 방문
    val sb = StringBuilder()
    val (N, M, V) = br.readLine().split(" ").map { it.toInt() }
    var graph = Array(N + 1) { mutableListOf<Int>() } //0은 안 씀
    val visited = BooleanArray(N + 1)
    repeat(M) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        // 양방향 연결
        graph[a].add(b)
        graph[b].add(a)
    }
    // 정렬해주기
    for (i in 0..N) {
        graph[i].sort()
    }
    dfs(graph, visited, V, sb)
    println(sb)


    // bfs용도 초기화
    sb.clear()
    for (i in visited.indices) {
        visited[i] = false
    }

    //
    bfs(graph, visited, V, sb)
    println(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, v: Int, sb: StringBuilder) {
    visited[v] = true // 방문 표시하고
    sb.append(v).append(" ")

    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            // 방문하지 않은 노드면 방문하기
            dfs(graph, visited, neighbor, sb)
        }
    }
}

fun bfs(graph: Array<MutableList<Int>>, visited: BooleanArray, v: Int, sb: StringBuilder) {
    visited[v] = true
    sb.append(v).append(" ")
    val queue = ArrayDeque<Int>()
    queue.addLast(v)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        for (neighbor in graph[current]) {
            if (!visited[neighbor]) {
                queue.addLast(neighbor)
                visited[neighbor] = true
                sb.append(neighbor).append(" ")
            }
        }
    }

}