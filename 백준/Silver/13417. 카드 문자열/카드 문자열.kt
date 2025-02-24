package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val N = br.readLine().toInt()
        val st = StringTokenizer(br.readLine())
        val queue = ArrayDeque<String>()
        queue.addLast(st.nextToken())
        repeat(N - 1) {
            val alphabet = st.nextToken()
            if (alphabet <= queue.first()) {
                queue.addFirst(alphabet)
            } else {
                queue.addLast(alphabet)
            }
        }
        queue.forEach { sb.append(it) }
        sb.append("\n")
    }
    print(sb)
    br.close()
}


