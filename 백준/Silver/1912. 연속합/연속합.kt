package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val userInput = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    dp[0] = userInput[0]
    var maxNum = dp[0]
    for (i in 1 until n) {
        dp[i] = maxOf(dp[i - 1] + userInput[i], userInput[i])
        maxNum = maxOf(maxNum, dp[i])
    }
    println(maxNum)
    br.close()
}

