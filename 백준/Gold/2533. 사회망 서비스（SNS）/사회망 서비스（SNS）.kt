package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    // 1~n번
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(N + 1)
    val dp = Array(N + 1) { IntArray(2) { 0 } } // 선택, 미선택
    dfs(graph, 1, visited, dp)
    //println(dp.contentDeepToString())
    println(minOf(dp[1][0], dp[1][1]))
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, dp: Array<IntArray>) {
    visited[v] = true
    dp[v][0] = 1 //선택한 경우
    dp[v][1] = 0 // 선택하지 않은 경우
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited, dp)
            dp[v][0] += minOf(dp[neighbor][0], dp[neighbor][1]) // 지금 v 선택하면 자식은 선택 작은 것으로
            dp[v][1] += dp[neighbor][0] // 지금 v를 선택 안하면 자식은 선택해야 함
        }
    }
}
