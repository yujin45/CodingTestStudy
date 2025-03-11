package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    // 입력 받기
    val K = br.readLine().toInt()
    repeat(K) {
        // 각 테스트 케이스
        val (V, E) = br.readLine().split(" ").map { it.toInt() }
        // 정점, 간선으로 그래프 구성
        val graph = Array(V + 1) { mutableListOf<Int>() }
        repeat(E) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            graph[a].add(b)
            graph[b].add(a)
        }

        // 이분 그래프가 될 수 있는 조건: 사이클이 생기지 않을 것
        val visited = IntArray(V + 1) { 0 } // 방문한 것 색을 -1, 1으로 표시할 것임
        var isBip = true
        for (i in 1..V) {// 분리된 그래프 있을 수 있어서 탐색해줘야 함
            if (visited[i] == 0) {
                visited[i] = 1 // 그래프 탐색 시작
                if (!dfs(graph, i, visited)) isBip = false
            }
        }

        if (isBip) {
            sb.append("YES\n")
        } else {
            sb.append("NO\n")
        }
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: IntArray): Boolean {

    for (neighbor in graph[v]) {
        if (visited[neighbor] == 0) {
            // 아직 방문하지 않은 곳이라면 방문
            visited[neighbor] = -visited[v] // 현재랑 반대 넣어주기
            if (!dfs(graph, neighbor, visited)) return false
        } else if (visited[neighbor] == visited[v]) {
            // 만약 방문했었는데 현재랑 같은 색이었다면 사이클
            return false
        }
    }
    return true
}