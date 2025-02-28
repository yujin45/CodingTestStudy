package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { IntArray(3) }
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        val r = st.nextToken().toInt()
        val g = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        dp[i][0] = minOf(dp[i - 1][1], dp[i - 1][2]) + r
        dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][2]) + g
        dp[i][2] = minOf(dp[i - 1][0], dp[i - 1][1]) + b
    }
    //println(dp.contentDeepToString())
    println(dp[n].min())
    br.close()
}
