package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    val stack = mutableListOf<Int>()
    val sequence = mutableListOf<Int>()
    val visited = BooleanArray(n + 1)

    fun backtrack(pushed: Int, popped: Int) {
        // 모든 원소를 pop하여 완성된 경우 출력
        if (popped == n) {
            sequence.forEach { sb.append(it).append(" ") }
            sb.deleteCharAt(sb.length - 1).append("\n")
            return
        }
        // pop 가능한 경우
        if (stack.isNotEmpty()) {
            val top = stack.removeLast()
            sequence.add(top) // pop한 숫자를 수열에 추가
            backtrack(pushed, popped + 1) // 다음 단계 진행
            sequence.removeLast() // 백트래킹
            stack.add(top) // pop한 숫자를 다시 스택에 넣음
        }
        // push 가능한 경우
        if (pushed < n) {
            stack.add(pushed + 1) // 1부터 n까지 push
            backtrack(pushed + 1, popped) // 다음 숫자 push
            stack.removeLast() // 백트래킹(이전 상태로 복구)
        }

    }
    backtrack(0, 0)
    print(sb)
    br.close()
}
