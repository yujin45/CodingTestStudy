package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sequence = IntArray(m)

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in start..n) {
            // i부터 탐색하고 중복 가능, 비내림차순 = 오름차순
            sequence[depth] = i
            backtrack(depth + 1, i) // 같은 숫자 i도 다시 선택 가능
        }
    }
    backtrack(0, 1)
    print(sb)
    br.close()
}
