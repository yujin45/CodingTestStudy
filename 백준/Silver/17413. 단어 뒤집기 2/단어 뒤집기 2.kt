package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    val result = StringBuilder()
    val temp = StringBuilder()
    var isOpen = false
    for (s in S) {
        if (s == '<') {
            result.append(temp.reverse())
            temp.clear()
            isOpen = true
            temp.append(s)
        } else if (s == '>') {
            isOpen = false
            temp.append(s)
            result.append(temp)
            temp.clear()
        } else if (!isOpen && s == ' ') {
            result.append(temp.reverse()).append(" ")
            temp.clear()
        } else {
            temp.append(s)
        }
    }
    result.append(temp.reverse())
    print(result)
    br.close()
}
