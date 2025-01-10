package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    //
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(n + 1)
    dfs(graph, 1, visited)
    //bfs(graph, 1, visited)
    println(visited.count { it } - 1)
    //
    br.close()
}
fun dfs(graph: List<MutableList<Int>>, start: Int, visited: BooleanArray) {
    visited[start] = true
    for (neighbor in graph[start]) {
        if (!visited[neighbor]) {
            // 방문전이면
            dfs(graph, neighbor, visited)
        }
    }
}

