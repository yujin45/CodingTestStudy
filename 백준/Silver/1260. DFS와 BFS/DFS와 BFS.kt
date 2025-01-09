package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()
    //
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val graph = MutableList(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(n + 1)

    dfs(graph, v, visited, sb)
    println(sb.trimEnd())
    sb.clear()
    bfs(graph, v, sb)
    println(sb.trimEnd())
    //
    br.close()
    bw.flush()
    bw.close()
}

fun dfs(graph: List<MutableList<Int>>, v: Int, visited: BooleanArray, sb: StringBuilder) {
    visited[v] = true
    sb.append("$v ")
    for (neighbor in graph[v].sorted()) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited, sb)
        }
    }
}

fun bfs(graph: List<MutableList<Int>>, start: Int, sb: StringBuilder) {
    val visited = BooleanArray(graph.size)
    val queue = ArrayDeque<Int>()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val v = queue.removeFirst()
        sb.append("$v ")
        for (neighbor in graph[v].sorted()) {
            if (!visited[neighbor]) {
                queue.add(neighbor)
                visited[neighbor] = true
            }
        }
    }
}