package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 전체 사람 수 n
    val (p1, p2) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt() // 관계 수 m
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }
    val visited = BooleanArray(n + 1)
    println(dfs(graph, p1, p2, visited, 0))

    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, p2: Int, visited: BooleanArray, depth: Int): Int {
    visited[v] = true
    //println("v $v / depth $depth / p2 $p2")
    if (v == p2) {
        return depth
    }
    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            val ret = dfs(graph, neighbor, p2, visited, depth + 1)
            if (ret != -1) {
                return ret
            }
        }
    }
    return -1
}