package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    // 정점 집합 2개로 분할
    // 각 집합 속 정점끼리 서로 인접하지 않도록 분할 -> 이분 그래프
    // 이분 그래프인지 아닌지 판별

    val K = br.readLine().toInt() // 테스트 케이스 개수
    val sb = StringBuilder()
    repeat(K) {
        val (V, E) = br.readLine().split(" ").map { it.toInt() }
        // 정점 1~v번
        val graph = Array(V + 1) { mutableListOf<Int>() }
        repeat(E) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }
        val color = IntArray(V + 1) { -1 } // -1: 방문 X, 0/1:그룹

        // 그래프의 모든 연결 요소에 대해 확인
        var isBipartite = true // 이분그래프인가?
        for (i in 1..V) {
            if (color[i] == -1) { // 방문하지 않은 노드에 대해서 BFS 실행
                if (!bfs(graph, i, color)) {
                    isBipartite = false
                    break
                }
            }
        }
        sb.append(if (isBipartite) "YES\n" else "NO\n")
    }
    print(sb)
    br.close()
}

// BFS로 이분 그래프 판별
fun bfs(graph: Array<MutableList<Int>>, start: Int, color: IntArray): Boolean {
    val queue = ArrayDeque<Int>()
    queue.addLast(start)
    color[start] = 0 // 시작 노드 색깔 설정

    while (queue.isNotEmpty()) {
        val node = queue.removeLast()
        for (neighbor in graph[node]) {
            if (color[neighbor] == -1) {
                // 아직 방문 전인 경우
                color[neighbor] = 1 - color[node] // 다음 이웃은 반대 색으로 칠하기
                queue.addLast(neighbor)
            } else if (color[neighbor] == color[node]) {
                // 방문했던 것인데 지금 node랑 같은 색이면, 인접한 노드끼리 같은 색 => 이분 그래프X
                return false // 홀수 사이클이 형성됨. 짝수 사이클은 색 다르게 칠해져서 괜찮
            }
        }
    }
    return true
}