package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 오름차순, 조합, 중복 제거
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sequence = IntArray(m)

    //println(numbers)
    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        var lastUsed = -1
        for (i in start until n) {
            if (lastUsed != numbers[i]) {
                sequence[depth] = numbers[i]
                lastUsed = numbers[i]
                backtrack(depth + 1, i + 1)
            }
        }
    }
    backtrack(0, 0)
    //
    print(sb)
    br.close()
}
