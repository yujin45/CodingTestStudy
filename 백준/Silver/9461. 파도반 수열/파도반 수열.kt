package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()
    val dp = LongArray(101)
    dp[1] = 1
    dp[2] = 1

    for(i in 3..100){
        dp[i] = (dp[i-3] + dp[i-2])
    }
    repeat(t){
        sb.append("${dp[br.readLine().toInt()]}\n")
    }
    print(sb)
    br.close()
}

