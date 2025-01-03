package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val deque = mutableListOf<Int>()
    repeat(n){
        deque.add(it+1)
    }
    val sb = StringBuilder()
    while(deque.isNotEmpty()){
        sb.append("${deque.first()} ")
        deque.removeFirst()
        if(deque.isNotEmpty()){
            val temp = deque.first()
            deque.removeFirst()
            deque.add(temp)
        }
    }
    println(sb)
}