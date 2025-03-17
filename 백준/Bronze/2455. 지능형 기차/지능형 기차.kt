package org.example

import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()

    var maxCount = 0
    var currentCount = 0

    repeat(4) {
        val st = StringTokenizer(br.readLine())
        currentCount -= st.nextToken().toInt()
        currentCount += st.nextToken().toInt()
        maxCount = maxOf(maxCount, currentCount)
    }
    println(maxCount)

    br.close()
}

