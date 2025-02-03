package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val num = br.readLine().map { it.digitToInt() }
    var sum = 0
    for (i in 0 until n) {
        sum += num[i]
    }
    println(sum)
    br.close()
}
