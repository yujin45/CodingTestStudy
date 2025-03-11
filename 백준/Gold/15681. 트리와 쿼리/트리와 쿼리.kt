package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    // 간선에 가중치와 방향성 없는 => 양방향
    val (N, R, Q) = br.readLine().split(" ").map { it.toInt() }
    // 정점 U를 루트로 하는 서브 트리에 속한 정점의 수
    val tree = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val st = StringTokenizer(br.readLine())
        val U = st.nextToken().toInt()
        val V = st.nextToken().toInt()
        tree[U].add(V)
        tree[V].add(U)
    }

    // q줄마다 subTree 개수 탐색하면 시간 초과할 가능성 있음.
    // 미리 subtree 다 계산해서 가지고 있기
    val subTreeCount = IntArray(N + 1)
    val visited = BooleanArray(N + 1)
    dfs(tree, R, visited, subTreeCount)
    //println(subTreeCount.contentToString())

    // Q에 대한 서브트리 개수 저장
    val sb = StringBuilder()
    repeat(Q) {
        val U = br.readLine().toInt()
        sb.append(subTreeCount[U]).append("\n")
    }
    print(sb)
    br.close()
}

fun dfs(graph: Array<MutableList<Int>>, v: Int, visited: BooleanArray, subTreeCount: IntArray): Int {
    var count = 1
    visited[v] = true

    for (neighbor in graph[v]) {
        if (!visited[neighbor]) {
            count += dfs(graph, neighbor, visited, subTreeCount)
        }
    }
    subTreeCount[v] = count
    return count
}