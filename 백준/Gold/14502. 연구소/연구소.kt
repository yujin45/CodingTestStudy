package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

private var maxSafeArea = 0
private lateinit var graph: Array<IntArray>
private var N = 0
private var M = 0

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    // 0 빈칸 / 1 벽 / 2 바이러스 : 2~10
    // 벽 3개 세우고 안전 영역의 최댓값
    graph = Array(N) { IntArray(M) }
    val emptySpaces = mutableListOf<Pair<Int, Int>>()
    val virusPositions = mutableListOf<Pair<Int, Int>>()

    // 입력 받기
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            graph[i][j] = st.nextToken().toInt()
            if (graph[i][j] == 0) emptySpaces.add(i to j) // 빈 칸 위치 저장
            if (graph[i][j] == 2) virusPositions.add(i to j) // 바이러스 위치 저장
        }
    }

    //graph.forEach { println(it.contentToString()) }
    // 벽 3개를 세울 모든 경우의 수 탐색
    combination(emptySpaces, 0, 0, mutableListOf())
    println(maxSafeArea)
    br.close()
}

// 벽 3개 세울 조합 찾기 (백트래킹)
fun combination(emptySpaces: List<Pair<Int, Int>>, start: Int, count: Int, selected: MutableList<Pair<Int, Int>>) {
    if (count == 3) {
        // 벽 3개를 모두 세웠다면
        val tempLab = graph.map { it.copyOf() }.toTypedArray() // 연구소 복사
        for ((x, y) in selected) tempLab[x][y] = 1 //벽 세우기

        val safeArea = simulateVirus(tempLab) // 바이러스 퍼뜨리고 안전 영역 계산
        maxSafeArea = maxOf(maxSafeArea, safeArea) // 최대 안전 영역 업데이트
        return
    }

    for (i in start until emptySpaces.size) {
        selected.add(emptySpaces[i])
        combination(emptySpaces, i + 1, count + 1, selected)
        selected.removeAt(selected.lastIndex)
    }
}

fun simulateVirus(tempLab: Array<IntArray>): Int {
    val queue = ArrayDeque<Pair<Int, Int>>()

    // 초기 바이러스 위치 다 넣고 돌리기 = > 토마토 문제랑 유사하게 동시에 퍼뜨리기
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (tempLab[i][j] == 2) queue.add(i to j) //초기 바이러스 위치
        }
    }

    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.removeFirst()
        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]
            if (nx in tempLab.indices && ny in tempLab[0].indices && tempLab[nx][ny] == 0) {
                tempLab[nx][ny] = 2 // 바이러스 확산
                queue.addLast(nx to ny)
            }
        }
    }

    return tempLab.sumOf { row -> row.count { it == 0 } }
}
