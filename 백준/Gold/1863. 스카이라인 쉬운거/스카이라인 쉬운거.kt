package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 이번 학기 몇분인지
    val stack = mutableListOf<Int>()
    var count = 0
    repeat(n) {
        val (_, y) = br.readLine().split(" ").map { it.toInt() }

        // 현재 높이보다 높은 모든 건물을 제거하면서 count 증가하기
        while (stack.isNotEmpty() && stack.last() > y) {
            stack.removeLast()
            count++
        }

        // 스택이 비어 있거나, 현재 높이가 기존 높이랑 다르면 추가
        if (y != 0 && (stack.isEmpty() || stack.last() != y)) {
            stack.add(y)
        }

        //println(stack)
    }
    // 스택에 남아 있는 건물도 카운트
    //println(stack)
    println(count + stack.size)
    br.close()
}