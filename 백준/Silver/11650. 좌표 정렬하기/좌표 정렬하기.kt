package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    val N = br.readLine().toInt()
    val points = mutableListOf<Pair<Int, Int>>()
    repeat(N) {
        val st = StringTokenizer(br.readLine())
        points.add(st.nextToken().toInt() to st.nextToken().toInt())
    }
    points.sortedWith(compareBy<Pair<Int, Int>> { it.first }
        .thenBy { it.second })
        .forEach {
            sb.append("${it.first} ${it.second}\n")
        }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}