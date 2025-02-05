package org.example

import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val homework = Array(n) {
        val (d, w) = br.readLine().split(" ").map { it.toInt() }
        d to w
    }.sortedBy { it.first } // 마감일 기준 빠른 것부터 보기 위함

    val pq = PriorityQueue<Int>() // 기간 내 할 수 있는 것들 중, 낮은 과제 제거용

    for ((d, w) in homework) {
        pq.add(w) // 현재 과제 추가
        if (pq.size > d) {
            // 지금 해낼 일들이 마감일을 넘어가면 과제 중 가장 낮은 것 빼기
            pq.poll()
        }
    }
    println(pq.sum())
    br.close()
}