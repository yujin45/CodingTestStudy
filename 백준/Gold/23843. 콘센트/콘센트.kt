package org.example

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    // n개 충전 // 사용 가능 m개
    // 최소 시간
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val needTime = br.readLine().split(" ").map { it.toInt() }.sortedDescending()

    val pq = PriorityQueue<Int>()
    for (time in needTime) {
        if (pq.size >= m) {
            pq.add(pq.poll() + time)
        } else {
            pq.add(time)
        }
        //println(pq)
    }
    println(pq.max())

    br.close()
}