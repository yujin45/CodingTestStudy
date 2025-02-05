package org.example

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val number = br.readLine()
    val stack = mutableListOf<Int>()
    // k개 지우는데 최대
    var popCount = k
    for (i in 0 until n) {
        val num = number[i].digitToInt()
        while (stack.isNotEmpty() && stack.last() < num && popCount > 0) {
            // 지금이 더 크면 제거하고 넣기
            stack.removeLast()
            popCount--
        }
        stack.add(num)
        //println(stack)
    }
    // 만약 위에서 k개를 지우지 못했을 경우가 있음.
    // 테스트 케이스에서는 없었으나 실제 채점에서는 있었나봄...
    // 아무튼! 남은 popCount는 제외하기
    for (i in 0 until stack.size - popCount) {
        sb.append(stack[i])
    }
    println(sb)
    br.close()
}