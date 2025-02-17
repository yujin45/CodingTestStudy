package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        sb.append(N - 1).append("\n") // 항상 최소 간선 개수 N-1
        repeat(M) { br.readLine() } // 불필요 입력 스킵
    }
    print(sb)
    br.close()
}

