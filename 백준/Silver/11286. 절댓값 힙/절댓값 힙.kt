package org.example

import java.util.PriorityQueue
import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val pq = PriorityQueue<Int>(compareBy({ it.absoluteValue }, { it }))
    val n = br.readLine().toInt()
    repeat(n) {
        val x = br.readLine().toInt()
        if (x != 0) {
            pq.add(x)
        } else {
            if (pq.isNotEmpty()) {
                sb.append(pq.poll()).append("\n")
            } else {
                sb.append("0\n")
            }
        }
    }
    print(sb)
    br.close()
}