package org.example

fun fib(num: Int, dp: IntArray): Int {
    if (dp[num] == -1) {
        dp[num] = fib(num - 1, dp) + fib(num - 2, dp)
    }
    return dp[num]
}

fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    val dp = IntArray(46) { -1 }
    dp[0] = 0
    dp[1] = 1
    println(fib(num, dp))
    br.close()
}

