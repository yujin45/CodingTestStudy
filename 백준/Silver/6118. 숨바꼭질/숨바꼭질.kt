package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(graph.size)
    val depth = 0
    val start = 1
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
    br.close()
}
