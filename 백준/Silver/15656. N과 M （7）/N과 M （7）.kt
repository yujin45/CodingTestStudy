package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sequence = IntArray(M)
    fun backtrack(depth: Int) {
        if (depth == M) {
            sequence.forEach { sb.append(it).append(" ") }
            sb.deleteCharAt(sb.length - 1).append("\n")
            return
        }
        for (i in nums) {
            sequence[depth] = i
            backtrack(depth + 1)
        }
    }
    backtrack(0)
    print(sb)

    br.close()
}