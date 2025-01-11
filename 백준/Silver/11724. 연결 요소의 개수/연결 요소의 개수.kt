package org.example


fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = BooleanArray(n + 1)
    var total = 0
    for (i in 1 until n + 1) {
        if (!visited[i]) {
            total += 1
            dfs(graph, i, visited)
        }
    }

    println("$total")
    br.close()

}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray) {
    visited[v] = true

    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited)
        }
    }
}