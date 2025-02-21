package org.example

import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val S = br.readLine()

    var needMinDay = 0
    var total = 0 //괄호 균형 체크

    for (c in S) {
        if (c == '(') total++
        else total--
        needMinDay = maxOf(needMinDay, abs(total))
    }
    println(if (total == 0) needMinDay else -1)
    br.close()
}
