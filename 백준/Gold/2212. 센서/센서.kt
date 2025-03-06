package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val K = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val sensors = PriorityQueue<Int>()
    repeat(N) {
        sensors.add(st.nextToken().toInt())
    }
    //println("sensors: $sensors")
    val pq = PriorityQueue<Int>(compareByDescending { it })
    var front = sensors.poll()
    repeat(N - 1) {
        val back = sensors.poll()
        pq.add(back - front)
        front = back
    }
    //println("pq: $pq")
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