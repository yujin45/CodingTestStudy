package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>() // 회의 끝나는 시간 체크용
    var st: StringTokenizer
    val timeTable = Array(n) {
        st = StringTokenizer(br.readLine())
        (st.nextToken().toInt() to st.nextToken().toInt())
    }.sortedBy { it.first } // 회의 시간 빠른 것을 먼저

    for ((start, end) in timeTable) {
        if (pq.isNotEmpty() && pq.peek() <= start) {
            pq.poll()
        }
        pq.add(end)
    }
    println(pq.size)
    br.close()
}