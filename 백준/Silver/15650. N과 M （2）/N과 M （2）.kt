package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    // 1~N까지 자연수 중 중복 없이 M개 구하기
    val sequence = IntArray(M) // M개 고를 배열
    val visited = BooleanArray(N + 1) // 중복 없이, 0은 안 씀

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
            // 1~N까지의 수인데 고른 수열이 오름차순이 되어야 함.
            if (!visited[i]) {
                // 방문하지 않은 수라면
                visited[i] = true
                sequence[depth] = i
                backtrack(depth + 1, i + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0, 1)
    print(sb)

    br.close()
}
