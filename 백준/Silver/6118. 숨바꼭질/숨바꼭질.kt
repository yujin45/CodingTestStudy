package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    dfs(graph, 1)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, start: Int) {
    val visited = BooleanArray(graph.size)
    val depth = 0
    val depthList = mutableListOf<Pair<Int, Int>>()
    visited[start] = true
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(start to depth)
    depthList.add(start to depth)
    while (queue.isNotEmpty()) {
        val (node, dist) = queue.removeFirst()
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                queue.addLast(neighbor to dist + 1)
                visited[neighbor] = true
                depthList.add((neighbor to dist + 1))
            }
        }
    }
    //println(depthList)
    depthList.sortWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
    val hideNum = depthList[0].first
    val hideDist = depthList[0].second
    var count = 0
    for ((_, dist) in depthList) {
        if (dist == hideDist) {
            count++
        } else {
            break
        }
    }
    println("$hideNum $hideDist $count")
}