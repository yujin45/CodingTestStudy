package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }
    val visited = BooleanArray(N + 1)
    val dp = Array(N + 1) { IntArray(2) } // 자기 선택 1, 자기선택x 0
    dfs(graph, 1, visited, dp) // 루트를 1이라고 생각하고 진행
    println(minOf(dp[1][0], dp[1][1]))

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, dp: Array<IntArray>) {
    visited[v] = true
    dp[v][1] = 1 // 자기 자신 선택
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited, dp)
            dp[v][1] += minOf(dp[neighbor][1], dp[neighbor][0])
            dp[v][0] += dp[neighbor][1]
        }
    }
}