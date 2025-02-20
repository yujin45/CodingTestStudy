package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val S = br.readLine()
    val result = mutableListOf<String>()
    for (i in S.indices) {
        result.add(S.substring(i))
    }
    result.sort()
    result.forEach { sb.append(it).append("\n") }
    print(sb)
    br.close()
}
