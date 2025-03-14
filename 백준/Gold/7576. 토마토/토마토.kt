package org.example

import java.util.StringTokenizer

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()

    val (M, N) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(N) { IntArray(M) }
    var queue = ArrayDeque<Pair<Int, Int>>()
    var notDoneTomato = 0
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            val tomato = st.nextToken().toInt()
            if (tomato == 0) {
                // 안 익은 토마토 개수 세어주기
                notDoneTomato++
            } else if (tomato == 1) {
                // 익은 토마토 위치 큐에 삽입해주기
                queue.add(i to j)
            }
            graph[i][j] = tomato
        }
    }

    // 모든 토마토가 익어 있는 상태 => 안 익은 토마토가 없는 경우
    if (notDoneTomato == 0) {
        println(0)
        return
    }

    var day = 0
    var temp = ArrayDeque<Pair<Int, Int>>()
    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.removeLast()
        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
                temp.add(nx to ny) // 다음 탐색지로 지정
                graph[nx][ny] = 1 // 토마토 있으면 익히기
                notDoneTomato-- // 익은거 하나 제거
            }

        }

        if (queue.isEmpty() && temp.isNotEmpty()) {
            // 하루 지나고 queue 교체해주기
            day++
            val dummy = queue
            queue = temp
            temp = dummy
        }
    }


    // 토마토가 모두 익지 못하는 상황이면
    if (notDoneTomato != 0) {
        // 다 돌았는데 0이 아니면 못 익는 것이 있음
        println(-1)
    } else {
        println(day)
    }

    br.close()
}

