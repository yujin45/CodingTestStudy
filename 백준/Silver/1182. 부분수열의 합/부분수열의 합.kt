package org.example

import kotlin.math.absoluteValue


fun main() {
    val br = System.`in`.bufferedReader()
    // 조합을 다 구한다
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }
    // 중복 숫자들 중에서 2, 3, -2, -2 가 있다고 하면 2, -2는 1번만 카운트해야 함
    // 2, -2랑 -2, 2도 같은 것 => 조합을 구해야 함
    // 자기 자신은 x
    var result = 0
    fun backtrack(depth: Int, start: Int, end: Int, sequence: IntArray) {
        if (depth == end) {
            // 몇개 뽑을지에 따라
            if (sequence.sum() == s) {
                //println("$start, $end, ${sequence.contentToString()}")
                result++
            }
            return
        }
        // -2, -2, 4 이런 경우가 있어서 lastUsed는 사용하지 않음.
        for (i in start until n) {
            sequence[depth] = numbers[i]
            backtrack(depth + 1, i + 1, end, sequence)
        }
    }

    // 1개만 뽑는 것도 s가 될 수 있음. 1부터 시작
    for (end in 1..n) {
        val sequence = IntArray(end)
        backtrack(0, 0, end, sequence)
    }

    println(result)
    br.close()
}
