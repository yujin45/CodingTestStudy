package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val P = listOf(0) + br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        // dp[i]를 채우기 위한 루프(1~n까지)
        for (j in 1..i) {
            // i개의 카드를 살 때 j개가 들어 있는 팩을 고려
            dp[i] = maxOf(dp[i], dp[i - j] + P[j])
        }
    }

    println(dp[n])
    br.close()
}