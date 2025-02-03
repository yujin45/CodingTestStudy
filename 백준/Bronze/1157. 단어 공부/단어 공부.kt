package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val word = br.readLine().uppercase()
    val freq = IntArray(26)

    for (char in word) {
        freq[char - 'A']++
    }

    val maxValue = freq.maxOrNull() ?: 0
    val maxCount = freq.count { it == maxValue }
    println(if (maxCount > 1) "?" else ('A' + freq.indexOf(maxValue)))

    br.close()
}
