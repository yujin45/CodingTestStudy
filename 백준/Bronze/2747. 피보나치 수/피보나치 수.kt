package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    val dp = IntArray(46)
    dp[0] = 0
    dp[1] = 1
    for (i in 2 until num + 1) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[num])
    br.close()
}
