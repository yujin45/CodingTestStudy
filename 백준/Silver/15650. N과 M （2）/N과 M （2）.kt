package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sequence = mutableListOf<Int>()

    fun backtrack(start: Int) {
        if (sequence.size == m) {
            sb.append("${sequence.joinToString(" ")}\n")
            return
        }
        for (i in start..n) { // 오름차순 위한 start부터 탐색
            sequence.add(i)
            backtrack(i + 1) // 다음 숫자는 i보다 +1
            sequence.removeLast() // 백트래킹
        }
    }
    backtrack(1)
    print(sb)
    br.close()
}
