package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

data class Edge(val a: Int, val b: Int, val cost: Int)

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent, parent[x])
    }
    return parent[x]
}

fun union(parent: IntArray, rank: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a)
    val rootB = find(parent, b)
    if (rootA != rootB) {
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB
        } else {
            parent[rootB] = rootA
            rank[rootA]++
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Edge>(compareBy<Edge> { it.cost })
    repeat(E) {
        val st = StringTokenizer(br.readLine())
        pq.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var totalCost = 0 // 가중치 합
    var edgeCount = 0 // N-1개 되면 스패닝 트리 완성

    val parent = IntArray(V + 1) { it }
    val rank = IntArray(V + 1) { 0 }

    // 크루스칼 알고리즘으로 진행
    while (pq.isNotEmpty()) {
        if (edgeCount == V - 1) break

        val edge = pq.poll() // 최소 가중치부터 뽑기
        if (find(parent, edge.a) != find(parent, edge.b)) {
            // 같은 그룹이 아니라면 합쳐주기
            union(parent, rank, edge.a, edge.b)
            totalCost += edge.cost
            edgeCount++
        }

    }
    println(totalCost)

    br.close()

}