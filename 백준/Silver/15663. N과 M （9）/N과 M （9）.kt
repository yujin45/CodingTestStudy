package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sequence = IntArray(M)
    val visited = BooleanArray(N)
    fun backtrack(depth: Int) {
        if (depth == M) {
            sequence.forEach { sb.append(it).append(" ") }
            sb.deleteCharAt(sb.length - 1).append("\n")
            return
        }
        var lastUsed = -1
        for (i in 0 until N) {
            if (!visited[i] && lastUsed != nums[i]) {
                visited[i] = true
                sequence[depth] = nums[i]
                lastUsed = nums[i]
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    print(sb)

    br.close()
}