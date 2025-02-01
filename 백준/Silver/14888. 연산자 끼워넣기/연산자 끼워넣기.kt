package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    // 주어진 수는 순서가 바뀌지 않음
    // 연산자의 조합만 바뀌는 것 + + - -, + +  - - 는 동일한 것으로 취급되는 것
    // 앞에서 진행, 나눗셈 정수 나눗셈 몫만 취하기
    // 음수 나누기 양수 -> 양수로 바꾼뒤 몫 가져와서 음수로 바꾸기
    // 식의 결과가 최대, 최소

    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }
    val operator = br.readLine().split(" ").map { it.toInt() }
    //
    // 덧셈, 뺄셈, 곱셈, 나눗셈
    val operators = mutableListOf<Int>()
    for (i in 0..3) {
        repeat(operator[i]) {
            operators.add(i)
        }
    }
    //println(operators)
    val visited = BooleanArray(operators.size)
    val operatorSequence = IntArray(operators.size)
    var minResult = Int.MAX_VALUE
    var maxResult = Int.MIN_VALUE
    fun backtrack(depth: Int) {
        if (depth == operators.size) {
            // 연산하기
            var temp = numbers[0]
            for (i in operatorSequence.indices) {
                when (operatorSequence[i]) {
                    0 -> temp += numbers[i + 1]
                    1 -> temp -= numbers[i + 1]
                    2 -> temp *= numbers[i + 1]
                    3 -> temp /= numbers[i + 1]
                }
            }
            minResult = minOf(temp, minResult)
            maxResult = maxOf(temp, maxResult)
            //println("$minResult,$maxResult")
            return
        }
        var lastUsed = -1
        for (i in operators.indices) {
            if (!visited[i] && lastUsed != operators[i]) {
                visited[i] = true
                operatorSequence[depth] = operators[i]
                lastUsed = operators[i]
                backtrack(depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack(0)
    println("$maxResult\n$minResult")
    br.close()
}
