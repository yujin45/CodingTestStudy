package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    // 조합을 다 구한다
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }
    var result = 0

    fun backtrack(depth: Int, start: Int, sum: Int) {
        if (depth > 0 && sum == s) { //공집합 제외
            result++
        }
        for (i in start until n) {
            backtrack(depth + 1, i + 1, sum + numbers[i]) // 합을 체크하면서 감
        }
    }
    backtrack(0, 0, 0)

    println(result)
    br.close()
}
