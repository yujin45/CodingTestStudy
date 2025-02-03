package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val word = br.readLine().uppercase()
    val map = hashMapOf<Char, Int>()
    // 빈도수 count
    for (w in word) {
        map[w] = map.getOrDefault(w, 0) + 1
    }

    // 최대 value
    val maxValue = map.values.maxOrNull()
    val maxKeys = map.filterValues { it == maxValue }.keys
    // 여러개이면 ? 하나면 KEY
    println(if (maxKeys.size > 1) "?" else maxKeys.first())

    br.close()
}
