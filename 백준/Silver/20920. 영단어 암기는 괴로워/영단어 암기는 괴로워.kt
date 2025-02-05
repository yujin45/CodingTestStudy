package org.example

import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val voca = HashMap<String, Int>()
    repeat(n) {
        val word = br.readLine()
        if (word.length >= m) {
            voca[word] = voca.getOrDefault(word, 0) + 1
        }
    }
    val sortedVoca = voca.entries.sortedWith(
        compareByDescending<Map.Entry<String, Int>> { it.value } // 등장 횟수 내림차순
            .thenByDescending { it.key.length } // 단어 길이 내림차순
            .thenBy { it.key } // 알파벳 순서 오름차순
    )
    //println(sortedVoca)
    sortedVoca.forEach {
        sb.append("${it.key}\n")
    }
    println(sb)
    br.close()
}