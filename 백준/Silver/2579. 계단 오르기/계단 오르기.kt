package org.example

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val table = IntArray(n + 1)
    table[0] = 0
    for (i in 1..n) {
        table[i] = br.readLine().toInt()
    }
    val dp = IntArray(n + 1)
    if (n == 1) {
        println(table[1])
    } else if (n == 2) {
        println(table[2] + table[1])
    } else {
        dp[1] = table[1]
        dp[2] = table[2] + table[1]
        dp[3] = maxOf(table[3] + table[1], table[3] + table[2])
        for (i in 4..n) {
            dp[i] = maxOf(dp[i - 2], dp[i - 3] + table[i - 1]) + table[i]
        }
        println(dp[n])
    }
    br.close()
}

