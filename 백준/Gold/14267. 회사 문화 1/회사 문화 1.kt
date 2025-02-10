package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() } //회사 직원수 n, 최초 칭찬 횟수 m

    // 1. 트리 생성
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val praise = IntArray(n + 1) { 0 } // 칭찬 저장 배열

    // 2. 부모 -자식 관계 설정
    val parentInfo = br.readLine().split(" ").map { it.toInt() }
    for (i in 1 until n) {
        // 직원번호 1부터 시작 0번 없음
        val boss = parentInfo[i] // i+1번 직원의 상사
        graph[boss].add(i + 1) // 부모 -> 자식 방향
    }

    // 3. 칭찬 입력(각 직원의 칭찬 수치 저장)
    repeat(m) {
        val (i, w) = br.readLine().split(" ").map { it.toInt() }
        praise[i] += w // 특정 직원 i가 받은 칭찬을 저장
    }

    // 4. DFS를 이용한 칭찬 전파
    fun dfs(node: Int) {
        for (child in graph[node]) {
            praise[child] += praise[node] // 부모의 칭찬을 자식에게 누적 전달
            dfs(child)
        }
    }

    dfs(1) // 사장 1번부터 dfs 시작

    // 5. 모든 직원의 칭찬 수치 출력
    val sb = StringBuilder()
    for (i in 1..n) {
        sb.append(praise[i]).append(" ")
    }
    sb.deleteCharAt(sb.length - 1)
    println(sb)
    br.close()
}
