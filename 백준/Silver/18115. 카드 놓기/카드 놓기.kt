package org.example

import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val ret = LinkedList<Int>()
    val command = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    for (card in (1..n)) {
        val cmd = command.removeLast()
        when (cmd) {
            1 -> ret.addFirst(card)
            2 -> ret.add(1, card)
            3 -> ret.addLast(card)
        }
    }
    for (r in ret) {
        sb.append("$r ")
    }

    print(sb)
    br.close()
}