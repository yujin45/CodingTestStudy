package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val height = br.readLine().split(" ").map { it.toInt() }
    // 이미 순서대로 줄 세움.
    val diff = IntArray(N - 1)
    // 1. 키 차이 뱅려
    for (i in 0 until N - 1) {
        diff[i] = (height[i + 1] - height[i])
    }
    // 2. 키 차이 정렬
    diff.sort()

    // 3. N-K만큼 합산 (N-1개 제거)
    val minCost = diff.take(N-K).sum()
    println(minCost)

    br.close()
}