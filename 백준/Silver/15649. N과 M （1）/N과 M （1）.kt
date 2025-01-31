package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val sequence = mutableListOf<Int>()
    val visited = BooleanArray(n + 1) // 1부터 N까지 사용 (0은 사용 X)

    fun backtrack() {
        if (sequence.size == m) {
            sb.append("${sequence.joinToString(" ")}\n")
            return
        }
        for (i in 1..n) {
            if (!visited[i]) {
                visited[i] = true
                sequence.add(i)
                backtrack()// 다음 숫자 탐색
                sequence.removeLast() // 백트래킹(이전 상태로 되돌리기) 1,2 하고서 1,3할 수 있게 2 제거
                visited[i] = false
            }
        }
    }
    backtrack()
    print(sb)
    br.close()
}

