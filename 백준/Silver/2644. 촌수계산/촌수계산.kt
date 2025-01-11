package org.example

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val (p1, p2) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }

    val visited = BooleanArray(n + 1)
    var count = 0
    println(dfs(graph, p1, p2, visited, count))

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, p2: Int, visited: BooleanArray, count: Int): Int {
    visited[v] = true
    if (v == p2) {
        return count
    }
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            val result = dfs(graph, neighbor, p2, visited, count + 1)
            if (result != -1) {
                return result
            }
        }
    }
    return -1
}