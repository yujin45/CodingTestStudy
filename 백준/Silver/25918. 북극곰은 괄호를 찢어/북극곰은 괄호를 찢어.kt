package org.example

import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val s = br.readLine()

    var needMinDay = 0
    var total = 0

    for(c in s){
        if(c == '('){
            total++
        }else if (c==')'){
            total--
        }
        needMinDay = maxOf(needMinDay, abs(total))
    }

    if(total == 0){
        println(needMinDay)
    }else{
        println(-1)
    }
}