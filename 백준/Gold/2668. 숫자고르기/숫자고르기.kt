package org.example

lateinit var graph: IntArray
lateinit var visited: BooleanArray
lateinit var finished: BooleanArray
val cycleSet = mutableSetOf<Int>() // 사이클에 포함된 숫자 저장

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    graph = IntArray(N + 1) // 1차원 배열로 그래프 저장
    visited = BooleanArray(N + 1) // 방문 체크 배열
    finished = BooleanArray(N + 1) // DFS 종료 여부 체크

    for (i in 1..N) {
        graph[i] = br.readLine().toInt() // 각 숫자가 가리키는 숫자 저장
    }

    // 1. 모든 숫자에 대해 DFS 실행 (중복 탐색 방지)
    for (i in 1..N) {
        if (!visited[i]) {
            dfs(i, mutableListOf())
        }
    }

    // 2. 결과 출력
    val result = cycleSet.sorted()
    println(result.size)
    result.forEach { println(it) }
}

// ✅ DFS 탐색 함수 (사이클 찾기)
fun dfs(v: Int, path: MutableList<Int>): Boolean {
    //println("🔍 탐색 시작: v = $v, path = $path")
    visited[v] = true
    path.add(v)
    val next = graph[v]

    if (!visited[next]) { // 아직 방문하지 않은 경우 DFS 탐색
        if (dfs(next, path)) return true
    } else if (!finished[next]) { // 방문했지만 DFS가 끝나지 않은 경우 -> 사이클 발생
        val cycleStart = path.indexOf(next) // 사이클 시작점 찾기

        if (cycleStart != -1) { // 예외 방지: indexOf(next)가 -1이면 subList 실행 X
            cycleSet.addAll(path.subList(cycleStart, path.size)) // 사이클 부분만 저장
            //println("🔁 사이클 발견! v = $v, cycleStart = $cycleStart, subpath = ${path.subList(cycleStart, path.size)}")
        }
        return true
    }

    finished[v] = true // DFS 종료 표시
    //println("✅ 탐색 종료: v = $v, finished[$v] = true")
    return false
}
