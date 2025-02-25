package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val computerNum = br.readLine().toInt() // 1~100
    val graph = Array(computerNum + 1) { mutableListOf<Int>() }
    val edgeNum = br.readLine().toInt()
    repeat(edgeNum) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
    val visited = BooleanArray(computerNum + 1)
    println(dfs(graph, 1, visited) - 1)

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray): Int {
    var count = 1
    visited[v] = true

    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            count += dfs(graph, neighbor, visited)
        }
    }

    return count
}
