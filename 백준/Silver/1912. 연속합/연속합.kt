package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    //val numbers = br.readLine().split(" ").map{it.toInt()}
    val dp = IntArray(n + 1)
    val st = StringTokenizer(br.readLine())

    var maxsum = Int.MIN_VALUE
    for (i in 1..n) {
        val num = st.nextToken().toInt()
        // 자기 자신과 비교해서 큰 거 가져가야 함
        //dp[i] = if (num + dp[i - 1] >= 0) num + dp[i - 1] else num
        dp[i] = maxOf(num + dp[i - 1], num)
        maxsum = maxOf(maxsum, dp[i])
    }
    //println(dp.contentToString())
    println(maxsum)
    br.close()
}
