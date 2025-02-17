package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(N + 1) { mutableListOf<Int>() }
        repeat(M) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            graph[a].add(b)
            graph[b].add(a)
        }
        val visited = IntArray(N + 1) { -1 }
        for (i in 1..N) {
            if (visited[i] == -1) {
                visited[i] = 1
                sb.append(dfs(graph, i, visited) - 1).append("\n")
            }
        }
    }
    print(sb)
    br.close()
}


fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: IntArray): Int {
    var count = 1
    for (neighbor in graph[v]) {
        if (visited[neighbor] == -1) {
            //println("$v, $neighbor 사이클 아님 ---")
            visited[neighbor] = 1 - visited[v]
            count += dfs(graph, neighbor, visited)
        }
//        }else if(visited[neighbor] == visited[v]){
//            // 사이클 발생
//            println("$v, $neighbor 사이클")
//        }
    }
    return count
}


