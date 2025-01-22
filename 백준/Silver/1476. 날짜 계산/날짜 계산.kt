package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (e, s, m) = br.readLine().split(" ").map { it.toInt() }
    var year = 1
    while (true) {
        if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0) {
            println("$year")
            break
        }
        year++
    }
    br.close()
}
