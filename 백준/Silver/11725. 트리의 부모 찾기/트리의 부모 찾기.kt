package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)
    val parent = IntArray(n + 1)

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (v in 1..n - 1) {
        if (!visited[v]) {
            dfs(graph, v, visited, parent)
        }
    }

    for (i in 2 until parent.size) {
        sb.append("${parent[i]}\n")
    }
    bw.write(sb.toString())
    bw.flush()
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, parent: IntArray) {
    visited[v] = true
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            parent[neighbor] = v
            dfs(graph, neighbor, visited, parent)
        }
    }
}