package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val t = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val hands = IntArray(2 * n)
    repeat(2 * n) {
        hands[it] = (st.nextToken().toInt())
    }
    //println("입력된 손: 아래 -  $hands - 위")
    val bs = StringTokenizer(br.readLine()) //t개의 b
    var index = 0
    repeat(t) {
        val bIndex = bs.nextToken().toInt() - 1
        index = (index + bIndex) % hands.size
        sb.append(hands[index]).append(" ")
    }
    sb.deleteCharAt(sb.length - 1)
    println(sb)
    br.close()
}