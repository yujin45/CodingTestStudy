package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val numbers = IntArray(N) { st.nextToken().toInt() }
    var count = 0
    fun backtrack(depth: Int, start: Int, currentSum: Int) {
        if (depth > 0 && currentSum == S) {
            count++
        }
        // 조합으로 구해야 하는데, 수열에 1, 1 이렇게 중복된 수 있을 수 있는데 이거 허용
        for (i in start until N) { // 자기 자신 포함 x로 i+1 넘기기
            backtrack(depth + 1, i + 1, currentSum + numbers[i])
        }
    }
    backtrack(0, 0, 0)
    println(count)
    br.close()
}