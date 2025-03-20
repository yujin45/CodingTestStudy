package org.example

import java.util.StringTokenizer
import java.util.TreeSet


fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val treeSet = TreeSet<String>(compareByDescending { it })
    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val command = st.nextToken()
        if (command == "enter") {
            treeSet.add(name)
        } else {
            treeSet.remove(name)
        }
    }
    val sb = StringBuilder()
    treeSet.forEach { sb.append(it).append("\n") }
    print(sb)
    br.close()
}
