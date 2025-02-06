package org.example

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val stack = mutableListOf<Int>()

    val n = br.readLine().toInt()
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        when (st.nextToken()) {
            "1" -> {
                stack.add(st.nextToken().toInt())
            }

            "2" -> {
                if (stack.isNotEmpty()) {
                    sb.append(stack.removeLast())
                } else {
                    sb.append(-1)
                }
                sb.append("\n")
            }

            "3" -> {
                sb.append(stack.size).append("\n")
            }

            "4" -> {
                if (stack.isEmpty()) {
                    sb.append(1)
                } else {
                    sb.append(0)
                }
                sb.append("\n")
            }

            "5" -> {
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