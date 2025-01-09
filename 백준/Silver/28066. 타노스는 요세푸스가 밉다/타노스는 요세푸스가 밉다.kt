package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque((1..n).toList())

    while (queue.size > 1) {
        if (queue.size <= k) {
            println(queue.first())
            break
        }
        queue.addLast(queue.removeFirst())
        repeat(k - 1) {
            queue.removeFirst()
        }
    }

}