package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    br.close()
    if (n < 2) {
        println(1)
    } else {
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 3
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
        }
        println(dp[n])
    }
}

