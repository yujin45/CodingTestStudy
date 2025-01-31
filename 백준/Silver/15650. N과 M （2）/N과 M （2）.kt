package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 중복 X, 1~n 중 m개 선택 - 조합, 오름차순
    val sequence = IntArray(m)

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in start..n) {
            sequence[depth] = i
            backtrack(depth + 1, i + 1)
        }
    }
    backtrack(0, 1)
    //
    print(sb)
    br.close()
}
