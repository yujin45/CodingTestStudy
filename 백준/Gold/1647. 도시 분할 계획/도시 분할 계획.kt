package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

data class Edge(val a: Int, val b: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.cost - other.cost // 유지비 오름차순
    }
}

// 유니온 파인드 find함수 (경로 압축 최적화)
fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent, parent[x])  // x의 부모가 x가 아니면 같아질 때까지 찾음
    }
    return parent[x]
}

// 유니온 파인드 union 함수 (랭크 기반 최적화)
fun union(parent: IntArray, rank: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a) // a의루트 찾기
    val rootB = find(parent, b) // b의 루트 찾기

    if (rootA != rootB) {
        // 서로의 루트가 다르다면 랭크 높은 트리에 합쳐줄 것임
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA // 랭크가 높은(숫자가 작은) 트리에 함치기
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB
        } else {
            // 동일하다면 b에 a합치고
            parent[rootB] = rootA
            rank[rootA] += 1 // 1랭크 업
        }
    }
}

// 크루스칼 알고리즘으로 최소 스패닝 트리 MST 비용 계산
fun kruskal(n: Int, edges: PriorityQueue<Edge>): Int {
    val parent = IntArray(n + 1) { it } // 부모 초기화
    val rank = IntArray(n + 1) { 0 } // 랭크 초기화

    var totalCost = 0
    var maxEdgeCost = 0
    var edgeCount = 0

    // 유지비가 낮은 순서대로 간선 정렬 후 MST 구성
    // 정렬된 간선을 받아와서 수행
    while (edges.isNotEmpty()) {
        val edge = edges.poll()
        if (edgeCount == n - 1) break // MST 완성 (n-1개의 간선 선택됨)
        if (find(parent, edge.a) != find(parent, edge.b)) {
            // 사이클 발생 방지
            union(parent, rank, edge.a, edge.b) // 합치기
            totalCost += edge.cost
            maxEdgeCost = edge.cost // 마지막으로 추가된 간선이 가장 큰 비용 간선(정렬 해두어서)
            edgeCount++
        }
    }
    return totalCost - maxEdgeCost // 가장 큰 간선 비용 제거 후 반환

}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() } // 집n, 거리 m

    val edges = PriorityQueue<Edge>()
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        edges.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    println(kruskal(n, edges))
    br.close()
}

