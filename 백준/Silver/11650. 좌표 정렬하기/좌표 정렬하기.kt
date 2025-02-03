package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val graph = Array(n) { IntArray(2) }
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[it][0] = x
        graph[it][1] = y
    }
    graph.sortedWith(compareBy({ it[0] }, { it[1] })).forEach {
        sb.append(it[0]).append(" ").append(it[1]).append("\n")
    }
    println(sb)

    br.close()
}