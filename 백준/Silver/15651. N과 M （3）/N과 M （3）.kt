package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    // 1~N까지 자연수 중 중복 없이 M개 구하기
    val sequence = IntArray(M) // M개 고를 배열

    fun backtrack(depth: Int) {
        if (depth == M) {
            sequence.forEach {
                sb.append(it).append(" ")
            }
            sb.deleteCharAt(sb.length - 1)
            sb.append("\n")
            return
        }

        for (i in 1..N) {
            // 같은 수를 여러번 골라도 됨 -> visited 필요 X
            sequence[depth] = i
            backtrack(depth + 1)
        }
    }
    backtrack(0)
    print(sb)

    br.close()
}
