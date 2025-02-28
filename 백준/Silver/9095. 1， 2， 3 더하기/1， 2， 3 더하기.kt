package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    val dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..10) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(t) {
        val n = br.readLine().toInt()
        sb.append("${dp[n]}\n")
    }
    print(sb)
    br.close()
}

