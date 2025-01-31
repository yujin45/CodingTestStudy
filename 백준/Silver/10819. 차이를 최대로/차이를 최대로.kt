package org.example

import kotlin.math.absoluteValue


fun main() {
    val br = System.`in`.bufferedReader()
    // 조합을 다 구한다
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    val sequence = IntArray(n)
    val visited = BooleanArray(n)
    var ret = -1

    fun mySum(sequence: IntArray): Int {
        var sum = 0
        for (i in 1 until sequence.size) {
            sum += (sequence[i - 1] - sequence[i]).absoluteValue
        }
        return sum
    }

    fun backtrack(depth: Int) {
        if (depth == n) {
            //println(sequence.joinToString(" "))
            ret = maxOf(mySum(sequence), ret)
            //println("ret = $ret")
            return
        }
        for (i in numbers.indices) {
            if (visited[i].not()) {
                visited[i] = true
                sequence[depth] = numbers[i]
                backtrack(depth + 1)
                visited[i] = false
            }

        }
    }
    backtrack(0)
    print(ret)
    br.close()
}
