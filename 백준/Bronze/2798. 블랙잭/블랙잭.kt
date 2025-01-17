package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toInt() }
    var ret = 0
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                val currentSum = cards[i] + cards[j] + cards[k]
                if (currentSum <= m) {
                    ret = maxOf(ret, currentSum)
                }
            }
        }
    }
    println(ret)
    br.close()
}