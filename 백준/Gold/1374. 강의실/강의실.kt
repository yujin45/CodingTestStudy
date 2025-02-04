package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()
    var st: StringTokenizer
    val timeTable = Array(n) {
        st = StringTokenizer(br.readLine())
        st.nextToken() // 넘버 필요 없음
        (st.nextToken().toInt() to st.nextToken().toInt())
    }.sortedBy { it.first }
    for ((start, end) in timeTable) {
        if (pq.isNotEmpty() && pq.peek() <= start) {
            // 재사용 가능
            pq.poll()
        }
        pq.add(end)
    }
    println(pq.size)
    br.close()
}