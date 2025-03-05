package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val alpha = IntArray(26) { -1 }
    val S = br.readLine()
    for (i in S.indices) {
        if (alpha[S[i] - 'a'] == -1) {
            alpha[S[i] - 'a'] = i
        }
    }
    //println(alpha.contentToString())
    val sb = StringBuilder()
    alpha.forEach { sb.append(it).append(" ") }
    sb.deleteCharAt(sb.length - 1)
    println(sb)


    br.close()
}