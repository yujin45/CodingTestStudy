package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    // N이 3백만
    val st = StringTokenizer(br.readLine())
    val pq = PriorityQueue<Int>(compareByDescending { it })
    var front = st.nextToken().toInt()
    repeat(N - 1) {
        val back = st.nextToken().toInt()
        pq.add(back - front)
        front = back
    }
    // 차이 내림 차순 중 가장 큰 K-1개를 선택해서 끊어주기
    repeat(K - 1) {
        pq.poll()
    }
    var sum = 0
    while (pq.isNotEmpty()) {
        sum += pq.poll()
    }
    println(sum)

    br.close()
}