package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 이번 학기 몇분인지
    val stack = mutableListOf<Pair<Int, Int>>()
    var total = 0
    repeat(n) {
        val userInput = br.readLine()
        if (userInput != "0") {
            val (_, A, T) = userInput.split(" ").map { it.toInt() }
            stack.add(A to T) // 받은 것 넣기
        }
        if(stack.isNotEmpty()){
            val top = stack.removeLast().let { (first, second) -> first to second - 1 }
            if (top.second == 0) {
                // 끝나면 점수 얻기
                total += top.first
            } else {
                // 아니면 다시 위에 올려두기
                stack.add(top)
            }
        }
        
        //println(stack)
    }
    println(total)
    br.close()
}