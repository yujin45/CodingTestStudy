package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 1~n까지 자연수 중에서 중복 없이 M개 고른 수열
    val sequence = IntArray(m)
    val visited = BooleanArray(n + 1)

    fun backtrack(depth: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in 1..n) {
            if (!visited[i]) { // 중복 제거
                visited[i] = true
                sequence[depth] = i
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    print(sb)

    br.close()
}
