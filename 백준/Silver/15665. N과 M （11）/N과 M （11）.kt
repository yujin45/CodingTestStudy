package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 오름차순, 순열, 중복 제거
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sequence = IntArray(m)
    fun backtrack(depth: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        var lastUsed = -1
        for (i in numbers.indices) {
            if (lastUsed != numbers[i]) {
                sequence[depth] = numbers[i]
                lastUsed = numbers[i]
                backtrack(depth + 1)
            }
        }
    }
    backtrack(0)
    //
    print(sb)
    br.close()
}
