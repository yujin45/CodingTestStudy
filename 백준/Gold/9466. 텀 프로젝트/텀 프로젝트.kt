package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val T = br.readLine().toInt()
    repeat(T) {
        val n = br.readLine().toInt()
        val graph = IntArray(n + 1)
        val st = StringTokenizer(br.readLine())
        for (i in 1..n) {
            graph[i] = st.nextToken().toInt()
        }
        val visited = BooleanArray(n + 1)
        val cycleSet = mutableSetOf<Int>()
        for (i in 1..n) {
            if (!visited[i]) dfs(graph, i, visited, mutableListOf(), cycleSet)
        }
        //println("$it 회차 : ${cycleSet.size} :$cycleSet")
        sb.append(n - cycleSet.size).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: IntArray, v: Int, visited: BooleanArray, path: MutableList<Int>, cycleSet: MutableSet<Int>) {
    //println("v: $v -----")
    visited[v] = true // 방문 표시
    path.add(v)
    val next = graph[v] // 1:1 연결만 있으므로 이웃은 1개

    if (!visited[next]) { // 아직 방문 전이라면 방문하기
        dfs(graph, next, visited, path, cycleSet)
    } else { // 방문했던 곳이고 현재 지나온 path에 있으면 사이클 형성된 것!
        // path.indexOf(next) ~ path.size : 사이클
        // 0 until path.indexOf(next) : 사이클 생기기 전 부분
        val cycleStart = path.indexOf(next)
        if (cycleStart != -1) { // -1이 아니면 사이클 형성, 사이클 찾고 이외의 것을 빼서 구하는 것
            //println("path: $path")
            cycleSet.addAll(path.subList(cycleStart, path.size))
            //println("next : $next")
            //println("cycleSet: $cycleSet")
            // 사이클 1팀 형성하는 것
        }
    }
}
