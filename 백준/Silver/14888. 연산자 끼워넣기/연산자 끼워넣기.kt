package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val stNumbers = StringTokenizer(br.readLine())
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = stNumbers.nextToken().toInt()
    }

    val stOperatorCounts = StringTokenizer(br.readLine())
    val operatorCounts = IntArray(4)
    for (i in 0 until 4) {
        operatorCounts[i] = stOperatorCounts.nextToken().toInt()
    }

    var maxResult = Int.MIN_VALUE
    var minResult = Int.MAX_VALUE

    // DFS 탐색: index는 현재 numbers의 인덱스, current는 지금까지 계산 결과
    fun dfs(index: Int, current: Int) {
        if (index == n) {
            maxResult = maxOf(maxResult, current)
            minResult = minOf(minResult, current)
            return
        }

        for (i in 0 until 4) {
            if (operatorCounts[i] > 0) { // 연산자가 남아 있는 경우 사용
                operatorCounts[i]-- // 연산자 개수 줄이고

                val nextNumber = numbers[index]
                val newResult = when (i) {
                    0 -> current + nextNumber
                    1 -> current - nextNumber
                    2 -> current * nextNumber
                    3 -> {
                        if (current < 0) {
                            -(-current / nextNumber)
                        } else {
                            current / nextNumber
                        }
                    }

                    else -> current
                }
                dfs(index + 1, newResult)
                operatorCounts[i]++ // 연산자 개수 복구 (백트래킹)
            }
        }
    }
    dfs(1, numbers[0])
    println("$maxResult\n$minResult")
    br.close()
}
