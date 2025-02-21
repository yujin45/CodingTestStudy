package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    var count = 0

    val N = br.readLine().toInt()
    for (i in 0 until N) {
        val stack = mutableListOf<Char>()
        val word = br.readLine()
        if (word.length % 2 == 1) continue // 홀수개면 애초에 짝이 안 맞아서 측정 패스
        for (w in word) {
            if (stack.isNotEmpty() && stack.last() == w) {
                stack.removeLast()
            } else {
                stack.add(w)
            }
        }
        if (stack.isEmpty()) count++
    }
    println(count)
    br.close()
}
