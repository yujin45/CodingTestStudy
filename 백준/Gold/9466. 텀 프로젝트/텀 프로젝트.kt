package org.example

import java.util.StringTokenizer

private var ret: Int = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val T = br.readLine().toInt()
    repeat(T) {
        val n = br.readLine().toInt()
        val graph = IntArray(n + 1)
        val st = StringTokenizer(br.readLine())
        for (i in 1..n) {
            graph[i] = st.nextToken().toInt()
        }
        val visited = BooleanArray(n + 1)
        val finished = BooleanArray(n + 1) // dfs 탐색 끝난 노드
        ret = 0
        for (i in 1..n) {
            if (!visited[i]) dfs(graph, i, visited, finished)
        }
        sb.append(n - ret).append("\n") // 총 학생 수 - 팀을 이룬 학생 수
    }
    print(sb)
    br.close()
}

fun dfs(graph: IntArray, v: Int, visited: BooleanArray, finished: BooleanArray) {
    visited[v] = true // 방문 표시
    val next = graph[v] // 1:1 연결만 있으므로 이웃은 1개

    if (!visited[next]) { // 아직 방문 전이라면 방문하기
        dfs(graph, next, visited, finished)
    } else if (!finished[next]) { // 사이클 발생인데 이미 이전에 탐색한 것 아니면
        var count = 1
        var i = next
        while (i != v) {
            count++
            i = graph[i]
        }
        ret += count
    }
    finished[v] = true
}
