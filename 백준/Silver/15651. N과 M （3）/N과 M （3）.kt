package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sequence = mutableListOf<Int>()

    fun backtrack() {
        if (sequence.size == m) {
            sb.append("${sequence.joinToString(" ")}\n")
            return
        }
        for (i in 1..n) {
            sequence.add(i)
            backtrack()
            sequence.removeLast()
        }
    }
    backtrack()
    print(sb)
    br.close()
}
