package org.example

import java.util.Queue
import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val queue: Queue<Int> = LinkedList()
    val sb = StringBuilder()

    for(number in 1..n){
        queue.offer(number)
    }

    while(queue.isNotEmpty()){
        sb.append("${queue.poll()} ")
        if(queue.isEmpty()) break
        queue.offer(queue.poll())
    }
    print(sb)
}