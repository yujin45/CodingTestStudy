package org.example

import java.util.Queue
import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val queue : Queue<Int> = LinkedList()

    repeat(n) {
        queue.add(it+1)
    }

    while(queue.size > 1){
        queue.poll()
        queue.add(queue.poll())
    }
    println(queue.poll())
}