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

    val (rootSelected, rootNotSelected) = dfs(graph, 1, visited) // 루트를 1이라고 생각하고 진행
    println(minOf(rootSelected, rootNotSelected))

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray): Pair<Int, Int> {
    visited[v] = true
    var selected = 1
    var notSelected = 0
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            val (neighborSelected, neighborNotSelected) = dfs(graph, neighbor, visited)
            selected += minOf(neighborSelected, neighborNotSelected)
            notSelected += neighborSelected
        }
    }
    return (selected to notSelected)
}