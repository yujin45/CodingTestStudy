package org.example

import java.util.StringTokenizer

data class Edge(val a: Int, val b: Int, val cost: Int)

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) {
        // 자기 자신이 될 때까지 탐색
        parent[x] = find(parent, parent[x]) // 경로 압축
    }
    return parent[x] // root 반환
}

fun union(parent: IntArray, rank: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a)
    val rootB = find(parent, b)

    if (rootA != rootB) {
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA // 트리 높이가 더 큰 쪽(rootA)으로 병합
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB // 트리 높이가 더 큰 쪽(rootB)으로 병합
        } else {
            parent[rootB] = rootA // 높이가 같다면 rootA가 rootB를 병합
            rank[rootA] += 1 // rootA의 랭크(트리 높이)를 증가
        }
    }
}


fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()
    repeat(M) {
        val st = StringTokenizer(br.readLine())
        edges.add(Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    // 유지비 오름차순 정렬
    edges.sortBy { it.cost }

    val parent = IntArray(N + 1) { it } // 부모 초기화
    val rank = IntArray(N + 1) { 0 }
    // rank[x]는 x가 루트일 때의 트리 깊이
    // 높이가 낮은 트릴르 높이가 더 높은 트리 밑으로 합치면 트리 깊이 최소화
    // 트리의 높이를 줄여서 find연산을 빠르게 수행하기 위해 rank 사용

    var totalCost = 0
    var maxEdgeCost = 0 // 가장 큰 유지비 간선 저장

    // 크루스칼 알고리즘 실행
    for (edge in edges) {
        if (find(parent, edge.a) != find(parent, edge.b)) {
            // root가 다르다면 다른 집합
            union(parent, rank, edge.a, edge.b)
            totalCost += edge.cost
            maxEdgeCost = edge.cost // 오름차순 정렬된 것 실행중이었으니까 마지막에 합쳐진 것이 가장 큰 비용 간선
        }
        // root가 같다면 같은 집합으로 사이클 생겨서 안됨
    }

    // 가장 큰 유지비 간선을 제거한 결과 출력
    println(totalCost - maxEdgeCost)
    br.close()
}

