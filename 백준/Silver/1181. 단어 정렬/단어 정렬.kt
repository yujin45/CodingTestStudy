package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    // 중복 단어 제거 필요
    val hashSet = HashSet<String>()
    repeat(n) {
        hashSet.add(br.readLine())
    }
    hashSet.sortedWith(compareBy({ it.length }, { it })).forEach {
        sb.append("$it\n")
    }
    println(sb)
    br.close()
}