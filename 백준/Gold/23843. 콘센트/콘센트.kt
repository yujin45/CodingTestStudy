package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val pq = PriorityQueue<Int>(compareByDescending { it })
    repeat(N) {
        pq.add(st.nextToken().toInt())
    }
    val charger = PriorityQueue<Int>()
    while (pq.isNotEmpty()) {
        if (charger.isEmpty() || charger.size < M) {
            charger.add(pq.poll())
        } else {
            val minCharger = charger.poll()
            charger.add(minCharger + pq.poll())
        }
    }
    println(charger.max())
    br.close()
}