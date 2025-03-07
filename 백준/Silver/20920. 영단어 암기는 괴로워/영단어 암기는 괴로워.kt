package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
  
    val hashMap = HashMap<String, Int>() // 단어 개수 세어주는 용도
    repeat(N) {
        val word = br.readLine()
        if (word.length >= M) {
            // 길이가 M이상 단어에 대해서만 처리
            hashMap[word] = hashMap.getOrDefault(word, 0) + 1 // 단어 개수 측정
        }
    }
    
    val sb = StringBuilder()

    hashMap.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }
        .thenByDescending { it.key.length }
        .thenBy { it.key }
    ).map { sb.append(it.key).append("\n") }
    println(sb)

    br.close()
}
