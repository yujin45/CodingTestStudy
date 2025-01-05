package org.example

import java.util.LinkedList
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()

    repeat(t){
        val (n, m) = br.readLine().split(" ").map{it.toInt()}
        val userInput = br.readLine().split(" ").map{it.toInt()}
        val queue = LinkedList(userInput.mapIndexed{i, v -> i to v})
        var printOrder = 0
        while(queue.isNotEmpty()){
            val current = queue.poll()
            if(queue.any { it.second > current.second }){
                queue.add(current)
            }else{
                printOrder++
                if(current.first == m){
                    sb.append("$printOrder\n")
                    break
                }
            }
        }
    }

    print(sb)
}