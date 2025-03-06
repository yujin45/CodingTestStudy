package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Int>(compareBy<Int> { abs(it) }.thenBy { it })
    val sb = StringBuilder()
    repeat(N) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (pq.isNotEmpty()) sb.append(pq.poll()).append("\n")
            else sb.append(0).append("\n")
        } else {
            pq.add(num)
        }
    }
    print(sb)
    br.close()
}