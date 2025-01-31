package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sequence = IntArray(m)

    fun backtrack(depth: Int) {
        if (depth == m) {
            sb.append("${sequence.joinToString(" ")}\n")
            return
        }
        for (i in 1..n) {
            sequence[depth] = i
            backtrack(depth + 1)
        }
    }
    backtrack(0)
    print(sb)
    br.close()
}
