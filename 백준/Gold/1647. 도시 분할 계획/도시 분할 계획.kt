package org.example

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val a: Int, val b: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost // 유지비 기준 오름차순 정렬
    }
}

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent, parent[x]) // 경로 압축
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
            rank[rootA] += 1
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Edge>() // 우선순위 큐 (최소 힙)

    repeat(M) {
        val st = StringTokenizer(br.readLine())
        pq.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    val parent = IntArray(N + 1) { it } // 부모 초기화
    val rank = IntArray(N + 1) { 0 }

    var totalCost = 0
    var maxEdgeCost = 0
    var edgeCount = 0 // 선택된 간선 개수
    // 크루스칼 알고리즘 (우선순위 큐 사용)
    while (pq.isNotEmpty()) {
        if (edgeCount == N - 1) break //N-1개의 간선이 선택되면 종료
        val edge = pq.poll() // 유지비가 가장 낮은 간선 꺼내기
        if (find(parent, edge.a) != find(parent, edge.b)) {
            union(parent, rank, edge.a, edge.b)
            totalCost += edge.cost
            maxEdgeCost = edge.cost // 가장 마지막으로 추가된 유지비가 가장 큰 값
            edgeCount++ // 선택된 간선 개수 증가
        }


    }
    // 가장 큰 유지비 간선 제거한 결과 출력
    println(totalCost - maxEdgeCost)
    br.close()
}