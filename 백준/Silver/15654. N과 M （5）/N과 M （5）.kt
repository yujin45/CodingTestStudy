package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 순열
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()

    val sequence = IntArray(m)
    val visited = BooleanArray(n)
    fun backtrack(depth: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in numbers.indices) {
            if (!visited[i]) {
                visited[i] = true
                sequence[depth] = numbers[i]
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    //
    print(sb)
    br.close()
}
