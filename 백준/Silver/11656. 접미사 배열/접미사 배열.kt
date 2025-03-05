package org.example

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    val pq = PriorityQueue<String>()
    for (i in S.indices) {
        pq.add(S.substring(i))
    }
    val sb = StringBuilder()
    while (pq.isNotEmpty()) {
        sb.append(pq.poll()).append("\n")
    }
    print(sb)
    br.close()
}