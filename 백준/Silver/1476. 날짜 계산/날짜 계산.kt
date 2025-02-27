package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val (E, S, M) = br.readLine().split(" ").map { it.toInt() }
    var year = 1
    while (true) {
        if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
            println(year)
            return
        }
        year++
    }
    br.close()
}
