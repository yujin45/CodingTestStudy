package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val sequence = IntArray(M)
    fun backtrack(depth: Int) {
        if (depth == M) {
            sequence.forEach {
                sb.append(it).append(" ")
            }
            sb.deleteCharAt(sb.length - 1)
            sb.append("\n")
            return
        }
        for (i in 1..N) {
            sequence[depth] = i
            backtrack(depth + 1)
        }
    }
    backtrack(0)
    print(sb)

    br.close()
}