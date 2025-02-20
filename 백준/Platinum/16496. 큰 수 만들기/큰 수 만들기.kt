package org.example

import java.util.Comparator
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val list = mutableListOf<String>()
    repeat(N) {
        list.add(st.nextToken())
    }
    list.sortedWith(Comparator { a, b ->
        (b + a).compareTo(a + b)
    }).forEach { sb.append(it) }

    println(if (sb.startsWith("0")) "0" else sb)
    br.close()
}
