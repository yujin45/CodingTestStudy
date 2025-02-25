package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

// 상, 하, 좌, 우
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            graph[i][j] = st.nextToken().toInt()
        }
    }
    val pq = PriorityQueue<Int>(compareByDescending { it })
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                pq.add(dfs(graph, i, j))
            }
        }
    }
    if(pq.isEmpty()){
        println("0\n0")
    }else{
        println(pq.size)
        println(pq.poll())
    }
    br.close()
}

fun dfs(graph: Array<IntArray>, x: Int, y: Int): Int {
    var count = 1
    graph[x][y] = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 1) {
            count += dfs(graph, nx, ny)
        }
    }
    return count
}
