package org.example

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        when (st.nextToken()) {
            "push" -> {
                stack.add(st.nextToken().toInt())
            }

            "pop" -> {
                if (stack.isNotEmpty()) {
                    sb.append(stack.removeLast())
                } else {
                    sb.append(-1)
                }
                sb.append("\n")
            }

            "size" -> {
                sb.append(stack.size).append("\n")
            }

            "empty" -> {
                if (stack.isEmpty()) {
                    sb.append(1)
                } else {
                    sb.append(0)
                }
                sb.append("\n")
            }

            "top" -> {
                if (stack.isNotEmpty()) {
                    sb.append(stack.last())
                } else {
                    sb.append(-1)
                }
                sb.append("\n")
            }
        }
    }
    print(sb)
    br.close()
}