package org.example

fun main() {
    val br = System.`in`.bufferedReader()

    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 2
    for (i in 3..1000) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }
    val n = br.readLine().toInt()
    print(dp[n])
    br.close()
}

