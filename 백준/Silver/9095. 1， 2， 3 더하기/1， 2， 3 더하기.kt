package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    val dp = IntArray(12) // n최대 11까지 -> 12로 크기 선언
    // 1, 2, 3을 만들 수 있는 개수 초기값
    dp[1] = 1 // 1
    dp[2] = 2 // 1+1, 2
    dp[3] = 4 // 1+1+1, 1+2, 2+1, 3

    for (i in 4..11) {
        // dp[n]: n을 1, 2, 3의 합으로 나타내는 방법의 수
        // n을 만들기 위해, n-1, n-2, n-3에서 1, 2, 3을 더한 경우의 수를 더함
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    repeat(T) {
        val num = br.readLine().toInt()
        sb.append(dp[num]).append("\n")
    }
    print(sb)
    br.close()
}
