package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 조합
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()

    val sequence = IntArray(m)

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in start until numbers.size) {
            sequence[depth] = numbers[i]
            backtrack(depth + 1, i + 1)
        }
    }
    backtrack(0, 0)
    //
    print(sb)
    br.close()
}
