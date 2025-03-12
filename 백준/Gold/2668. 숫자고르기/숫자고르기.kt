package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    /*
    index가 가리키는 노드들로 구성된 그래프에서
    사이클이 형성된 노드들을 구하면 고른 index집합과 값 집합이 동일해진다.
    즉, 사이클이 형성되는 노드들을 구하면 된다.
    * */

    val N = br.readLine().toInt() // 1 ~ 100
    val graph = IntArray(N + 1)
    for (i in 1..N) {
        graph[i] = br.readLine().toInt()
    }
    // 0이 방문 전, 방문 한 것 -1, 1로 둔다.

    val result = mutableListOf<Int>()
    val cycleVisited = BooleanArray(N + 1)
    for (i in 1..N) {
        if (!cycleVisited[i]) {
            val visited = BooleanArray(N + 1)
            result += dfs(graph, i, visited, mutableListOf(), cycleVisited)
            //println(result)
        }

    }
    result.sort()
    val sb = StringBuilder()
    sb.append(result.size).append("\n")
    result.forEach { sb.append(it).append("\n") }
    print(sb)

    // 뽑힌 정수들은 작은수 -> 큰수 순서로 = 오름차순으로 한줄에 하나씩 출력한다.
    br.close()
}

fun dfs(graph: IntArray, v: Int, visited: BooleanArray, path: MutableList<Int>, cycleVisited: BooleanArray): List<Int> {
    visited[v] = true
    path.add(v)
    //println("v:$v - path: $path")
    val neighbor = graph[v]
    if (!visited[neighbor]) {
        //println(cycleVisited.contentToString())
        if (cycleVisited[neighbor]) return listOf()

        val ret = dfs(graph, neighbor, visited, path, cycleVisited)
        if (ret.isNotEmpty()) return ret
    } else { // 사이클 발생
        // path에서 neighbor 부터 현재까지가 사이클
        //println("사이클이다!")
        val temp = path.subList(path.indexOf(neighbor), path.size)
        //println("${path.indexOf(neighbor)} / $temp")
        for (t in temp) {
            cycleVisited[t] = true
        }
        return temp
    }
    return listOf()
}