package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val p = IntArray(n + 1) { 0 } // 계단 점수 저장

    for (i in 1..n) {
        p[i] = br.readLine().toInt()
    }

    if (n == 1) {
        println(p[1])
        return
    } else if (n == 2) {
        println(p[1] + p[2])
        return
    }

    val dp = IntArray(n + 1) { 0 }
    dp[1] = p[1]
    dp[2] = p[1] + p[2]
    dp[3] = maxOf(p[1] + p[3], p[2] + p[3]) // 1, 3인 경우 2, 3인 경우

    for (i in 4..n) {
        // i-3, i-2, i-1, i 있을 때 현재 i 이전을 밟았는지 안 밟았는지에 따라
        // O X O 인 경우와 O X 인 경우
        dp[i] = maxOf(dp[i - 3] + p[i - 1], dp[i - 2]) + p[i]
    }
    println(dp[n])
    br.close()
}
