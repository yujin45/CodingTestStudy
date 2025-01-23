package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val t = IntArray(n + 1)
    val p = IntArray(n + 1)
    val dp = IntArray(n + 2) { 0 }

    for (i in 1..n) {
        val (ti, pi) = br.readLine().split(" ").map { it.toInt() }
        t[i] = ti
        p[i] = pi
    }

    for (i in n downTo 1) {
        if (i + t[i] <= n + 1) {
            dp[i] = maxOf(dp[i + 1], p[i] + dp[i + t[i]])
        } else {
            dp[i] = dp[i + 1]
        }
    }
    println(dp[1])

    br.close()
}

