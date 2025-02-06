package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val userInput = br.readLine()
//    var isOpen = false
    var insideTag = false // 태그인지 아닌지만 판단
    var temp = StringBuilder()
    for (c in userInput) {
        when {
            c == '<' -> {
                sb.append(temp.reverse()) // 단어 뒤집기
                temp.clear()
                sb.append(c) // 현재 기호 넣기
                insideTag = true
            }

            c == '>' -> {
                sb.append(c)
                insideTag = false
            }

            insideTag -> {
                // ★ 여기가 포인트!! 태그 내부의 문자는 그대로 출력!
                // 그래서 when(c)로 하는게 아니라 when{}으로 하는 것!
                sb.append(c)
            }

            c == ' ' -> {
                sb.append(temp.reverse()) // 뒤집어서 넣기
                temp.clear()
                sb.append(c)
            }

            else -> {
                temp.append(c)
            }
        }

    }
    sb.append(temp.reverse())
    println(sb)

    br.close()
}