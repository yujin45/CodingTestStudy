package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val userInput = Array<IntArray>(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array<IntArray>(n) { IntArray(3) }

    for (i in 0..2) {
        dp[0][i] = userInput[0][i]
    }

    for (i in 1 until n) {
        for (j in 0 until 3) {
            if (j == 0) {
                dp[i][j] = minOf(dp[i - 1][1], dp[i - 1][2]) + userInput[i][j]
            } else if (j == 1) {
                dp[i][j] = minOf(dp[i - 1][0], dp[i - 1][2]) + userInput[i][j]
            } else if (j == 2) {
                dp[i][j] = minOf(dp[i - 1][0], dp[i - 1][1]) + userInput[i][j]
            }
        }
    }
    //println(dp.contentDeepToString())
    println(dp[n - 1].min())
    br.close()
}

