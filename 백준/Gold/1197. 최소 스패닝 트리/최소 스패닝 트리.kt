package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

data class Edge(val a: Int, val b: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost
    }
}

// 유니온 파인드 : find
fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        // 지금 자기 자신이랑 같지 않으면 루트 값으로 맞춰주기
        parent[x] = find(parent, parent[x])
    }
    return parent[x]
}

fun union(parent: IntArray, rank: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a) //a의 루트 찾기
    val rootB = find(parent, b) // b의 루트 찾기

    if (rootA != rootB) {
        // 서로의 루트가 다르다면 랭크 높은 트리에 합쳐주기
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA // 랭크 높은 트리 합치기
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB // rootA를 rootB 아래로 두는 것
        } else {
            // 동일하다면
            parent[rootB] = rootA // rootB를 rootA로 두어서 rootA가 루트가 되게 함
            rank[rootA] += 1 // 1랭크업 잡아 먹은거라고 생각하기
        }
    }

}

fun kruskal(n: Int, edges: PriorityQueue<Edge>): Int {
    val parent = IntArray(n + 1) { it } // 노드 n개에 대해서 부모 자기 자신으로 초기화(0번은 안 씀)
    val rank = IntArray(n + 1) { 0 }
    var totalCost = 0
    var edgeCount = 0

    while (edges.isNotEmpty()) {
        if (edgeCount == n - 1) break // n-1개 간선 완성되면 종료
        val edge = edges.poll() // 정렬된 상태로 빼오기 가장 작은 cost부터
        if (find(parent, edge.a) != find(parent, edge.b)) {
            // 사이클 방지. 자기 부모 다를 때만 합치기
            union(parent, rank, edge.a, edge.b)
            totalCost += edge.cost
            edgeCount++
        }

    }
    return totalCost
}

fun main() {
    val br = System.`in`.bufferedReader()

    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val edges = PriorityQueue<Edge>()
    repeat(E) {
        val st = StringTokenizer(br.readLine())
        edges.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    println(kruskal(V, edges))

    br.close()
}

