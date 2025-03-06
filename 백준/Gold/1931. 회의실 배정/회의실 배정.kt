package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    // 끝나는 시간이 빨라야 많은 강의 시작 가능!! 끝나는 것 오름차순이 먼저!
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second }
        .thenBy { it.first })

    repeat(N) {
        val st = StringTokenizer(br.readLine())
        pq.add(st.nextToken().toInt() to st.nextToken().toInt())
    }

    var roomEnd = pq.poll().second // 가장 빨리 끝나는 강의 종료시간
    var count = 1
    while (pq.isNotEmpty()) {
        val (start, end) = pq.poll()
        if (start >= roomEnd) {
            //println("$start $end")
            count++
            roomEnd = end
        }
    }
    println(count)
    br.close()
}