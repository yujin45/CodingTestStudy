package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val K = br.readLine().toInt() // 테스트 케이스
    repeat(K) {
        val (V, E) = br.readLine().split(" ").map { it.toInt() }
        // 정점 개수 V, 간선 개수 E
        val graph = Array(V + 1) { mutableListOf<Int>() }
        repeat(E) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            graph[a].add(b)
            graph[b].add(a)
        }
        val visited = IntArray(V + 1) { -1 }
        val finished = BooleanArray(V + 1)
        var isBipartite = true
        for (i in 1..V) {
            if (visited[i] == -1) {
                visited[i] = 0 // 초기값 설정
                if (!dfs(graph, i, visited, finished)) {
                    isBipartite = false
                    break
                }
            }
        }
        if (isBipartite) {
            // 이분 그래프
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }

    }

    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: IntArray, finished: BooleanArray): Boolean {
    for (neighbor in graph[v]) {
        if (visited[neighbor] == -1) {
            visited[neighbor] = 1 - visited[v]
            if (!dfs(graph, neighbor, visited, finished)) return false
        } else if (!finished[neighbor] && visited[v] == visited[neighbor]) {
            // dfs 끝난 곳이 아닐 때, 이미 방문했고 홀수 사이클이면
            return false
        }
    }
    finished[v] = true
    return true
}
