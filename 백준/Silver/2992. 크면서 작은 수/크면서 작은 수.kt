package org.example


fun main() {
    val br = System.`in`.bufferedReader()

    val X = br.readLine()
    val XNum = X.toInt()
    var minResult = Int.MAX_VALUE
    // 구성은 같은데 X보다 큰 수 중 가장 작은수
    val visited = BooleanArray(X.length)
    val sequence = CharArray(X.length)
    fun backtrack(depth: Int) {
        if (depth == X.length) {
            val candidate = sequence.joinToString("").toInt()
            //println("Candidate $candidate   seq: ${sequence.contentToString()} X.length : ${X.length}")
            if (candidate > XNum) {
                minResult = minOf(minResult, candidate)
            }
            return
        }
        for (i in X.indices) {
            if (!visited[i]) {
                //println("${i} ====== ${X[i]}")
                visited[i] = true
                sequence[depth] = X[i]
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    if (minResult == Int.MAX_VALUE) {
        println(0)
    } else {
        println(minResult)
    }
    br.close()
}
