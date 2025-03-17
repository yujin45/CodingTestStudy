package org.example

import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val numbers = mutableListOf<String>()
    repeat(N) {
        numbers.add(st.nextToken())
    }

    val sb = StringBuilder()
    numbers.sortedWith(
        Comparator { a, b ->
            // b+a가 작으면 앞으로 오게
            (b + a).compareTo(a + b)
        }
    ).forEach { sb.append(it) }

    println(if (sb.startsWith("0")) "0" else sb)
    br.close()
}

