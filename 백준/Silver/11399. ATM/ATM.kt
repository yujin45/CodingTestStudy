package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    // 1~n번
    val p = br.readLine().split(" ").map { it.toInt() }.sorted()
    var sum = 0
    var result = 0
    for (i in 0 until n) {
        sum += p[i]
        result += sum
    }
    println(result)
    br.close()
}