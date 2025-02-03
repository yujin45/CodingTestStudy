package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val aList = br.readLine().split(" ").map { it.toInt() }.toHashSet()
    val m = br.readLine().toInt()
    val bList = br.readLine().split(" ").map { it.toInt() }
    bList.forEach {
        if (it in aList) sb.append(1) else sb.append(0)
        sb.append("\n")
    }
    println(sb)
    br.close()
}