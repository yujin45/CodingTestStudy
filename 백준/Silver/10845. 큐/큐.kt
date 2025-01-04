package org.example

import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val queue = LinkedList<String>()
    val sb = StringBuilder()
    repeat(n) {
        val command = br.readLine().split(" ")
        when(command[0]) {
            "push" -> {
                queue.add(command[1])
            }
            "pop"->{
                if(queue.isNotEmpty()){
                    sb.append("${queue.poll()}\n")
                }else{
                    sb.append("-1\n")
                }
            }
            "size"->{
                sb.append("${queue.size}\n")
            }
            "empty"->{
                if(queue.isEmpty()){
                    sb.append("1\n")
                }else{
                    sb.append("0\n")
                }
            }
            "front"->{
                if(queue.isEmpty()){
                    sb.append("-1\n")
                }else{
                    sb.append("${queue.first()}\n")
                }
            }
            "back"->{
                if(queue.isEmpty()){
                    sb.append("-1\n")
                }else{
                    sb.append("${queue.last()}\n")
                }
            }
        }

    }
    print(sb)

}