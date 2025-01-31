package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // 중복 X, 1~n 중 m개 선택 수열, 오름차순
    val sequence = IntArray(m) // m개 선택한 숫자 넣어지는 용도
    val visited = BooleanArray(n + 1) // 중복 체크용도 1~n

    fun backtrack(depth: Int) {
        if (depth == m) { // m개면 return
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        for (i in 1..n) { // 1부터 n까지
            if (!visited[i]) { // 중복 X
                visited[i] = true
                sequence[depth] = i
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
