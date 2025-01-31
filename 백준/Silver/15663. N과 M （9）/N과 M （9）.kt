package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    //  중복 제거한 순열
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted()

    val sequence = IntArray(m)
    val visited = BooleanArray(n)

    fun backtrack(depth: Int) {
        if (depth == m) {
            sequence.forEach { sb.append("$it ") }
            sb.append("\n")
            return
        }
        var lastUsed = -1 // 이전에 사용한 값 저장
        for (i in numbers.indices) {
            if (visited[i].not() && numbers[i] != lastUsed) { // 중복된 숫자 연속 선택 방지
                visited[i] = true
                sequence[depth] = numbers[i]
                lastUsed = numbers[i] // 현재 값 기록하여 중복 방지
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
