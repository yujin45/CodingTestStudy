package org.example

import java.util.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val alphaList = br.readLine().split(" ")

        val ret = ArrayDeque<String>()

        ret.add(alphaList[0])
        for (i in 1 until n) {
            if (ret.first() >= alphaList[i]) {
                ret.addFirst(alphaList[i])
            } else {
                ret.add(alphaList[i])
            }
        }
        for (r in ret) {
            sb.append(r)
        }
        sb.append("\n")
    }
    print(sb)
    br.close()
}