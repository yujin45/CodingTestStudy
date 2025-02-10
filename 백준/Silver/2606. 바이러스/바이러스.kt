package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val computerNum = br.readLine().toInt()
    val edge = br.readLine().toInt()
    val graph = Array(computerNum + 1) { mutableListOf<Int>() }
    repeat(edge) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        // 양방향 서로 연결
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(computerNum + 1)
    println(dfs(graph, 1, visited) - 1)

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray): Int {
    visited[v] = true
    var count = 1
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            count += dfs(graph, neighbor, visited)
        }
    }
    return count
}
