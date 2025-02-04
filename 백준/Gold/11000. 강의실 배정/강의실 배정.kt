package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    // 회의실 배정 문제와 유사할 것 같음
    // 끝나는 시간 -> 동일하면 시작 시간으로 우선 정렬하기
    var st: StringTokenizer
    var timeTable = Array(n) {
        st = StringTokenizer(br.readLine())
        (st.nextToken().toInt() to st.nextToken().toInt())
    }.sortedBy { it.first }

    val pq = PriorityQueue<Int>() // 끝나는 시간 기준 최소 힙

    for ((start, end) in timeTable) {
        // 현재 가장 빨리 끝나는 강의실이 새로운 강의 시작 전에 끝나면 재사용
        if (pq.isNotEmpty() && pq.peek() <= start) {
            pq.poll() // 제거하고 넣을 것
        }
        // 지금 강의 시작해야 하는데 아직 다 안 끝났다면 새 강의실에 새 강의 종료 시간 추가
        pq.add(end)
    }
    println(pq.size)
    br.close()
}