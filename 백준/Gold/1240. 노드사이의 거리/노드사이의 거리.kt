package org.example

import java.util.StringTokenizer

data class Node(val num: Int, val dist: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val tree = Array(N + 1) { mutableListOf<Node>() }

    repeat(N - 1) {
        // N개의 노드로 이루어진 트리
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val dist = st.nextToken().toInt()

        // 트리 구성하기
        tree[a].add(Node(b, dist))
        tree[b].add(Node(a, dist))
    }

    //println(tree.contentDeepToString())

    val sb = StringBuilder()
    repeat(M) {
        // 거리를 알고 싶은 노드 한 쌍
        val st = StringTokenizer(br.readLine())
        val visited = BooleanArray(N + 1)
        // 두 노드 사이의 거리 출력
        sb.append(dfs(tree, st.nextToken().toInt(), st.nextToken().toInt(), visited, 0)).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Node>>, v: Int, target: Int, visited: BooleanArray, dist: Int): Int {
    visited[v] = true
    if (v == target) {
        return dist
    }
    for ((neighbor, cost) in graph[v]) {
        if (!visited[neighbor]) {
            val ret = dfs(graph, neighbor, target, visited, dist + cost)
            if (ret != -1) return ret
        }
    }
    return -1 // 타겟 못찾은 것
}
