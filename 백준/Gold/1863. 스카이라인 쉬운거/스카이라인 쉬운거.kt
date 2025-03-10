package org.example

import java.util.StringTokenizer

data class Homework(val A: Int, var T: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val stack = mutableListOf<Pair<Int, Int>>()
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val cx = st.nextToken().toInt()
        val cy = st.nextToken().toInt()

        while (stack.isNotEmpty()) {
            //println(stack)
            val (tx, ty) = stack.last() // 제일 위의 것 확인
            if (ty >= cy) {
                // 현재 y보다 같거나 크면 제거
                if (ty > cy) {
                    count++
                }
                stack.removeLast()
            } else {
                break
            }
        }

        if (cy != 0) stack.add(cx to cy) // 바닥은 건물로 넣지 않음
    }

    while (stack.isNotEmpty()) {
        count++
        stack.removeLast()
    } // 남은 건물 수 카운트
    println(count)

    br.close()
}
