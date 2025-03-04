package org.example

// 조합
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    // 1~N까지 자연수 중 중복 없이 M개 구하기
    val sequence = IntArray(M) // M개 고를 배열

    fun backtrack(depth: Int, start: Int) {
        if (depth == M) {
            sequence.forEach {
                sb.append(it).append(" ")
            }
            sb.deleteCharAt(sb.length - 1)
            sb.append("\n")
            return
        }

        for (i in start..N) {
            // 1~N까지의 수인데 고른 수열이 오름차순이 되어야 함. 같은 수 골라도 됨 = visited필요x
            sequence[depth] = i
            backtrack(depth + 1, i) // 그리고 같은 수 골라도 되니까 i+1로 다음 수부터 고르게 안해도 됨
        }
    }
    backtrack(0, 1)
    print(sb)

    br.close()
}