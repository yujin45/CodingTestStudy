package org.example

import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    sb.append("<")
    val queue = LinkedList<Int>()

    for (i in 1..N) {
        queue.addLast(i)
    }

    var index = 0
    var nextK = K - 1 // index 앞에 제거되어서 k-1
    while (queue.size > 1) { // 0 나누지 않게
        index = (index + nextK) % queue.size
        sb.append(queue.removeAt(index)).append(", ")
        // 중간 삭제가 있으므로 ArrayDeque보다 LinkedList
    }
    sb.append(queue[0]).append(">")
    println(sb)

    br.close()
}
