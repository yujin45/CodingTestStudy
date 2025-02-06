package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    // 단어만 뒤집기
    val stack = mutableListOf<Char>()
    val sb = StringBuilder()
    val userInput = br.readLine()
    var isOpen = false
    for (c in userInput) {
        if (c == '<') {
            while (stack.isNotEmpty()) {
                sb.append(stack.removeLast())
            }
            sb.append(c)
            isOpen = true

        } else if (c == '>') {
            sb.append(c)
            isOpen = false
        } else if (isOpen) {
            sb.append(c)
        } else if (!isOpen && c == ' ') {
            // 닫혀있는데 공백이면
            while (stack.isNotEmpty()) {
                sb.append(stack.removeLast())
            }
            sb.append(c)
        } else {
            stack.add(c)
        }
    }
    while (stack.isNotEmpty()) {
        sb.append(stack.removeLast())
    }
    println(sb)

    br.close()
}