package org.example

import java.util.StringTokenizer

data class Score(val name: String, val k: Int, val e: Int, val m: Int)

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    val scores = Array(n) {
        val st = StringTokenizer(br.readLine())
        Score(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedWith(compareByDescending<Score> { it.k }
        .thenBy { it.e }
        .thenByDescending { it.m }
        .thenBy { it.name }
    ).forEach {
        sb.append(it.name).append("\n")
    }
    println(sb)
    br.close()
}