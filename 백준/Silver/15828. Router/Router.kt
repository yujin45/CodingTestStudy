package org.example

import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 버퍼 크기
    val router = LinkedList<Int>()
    var routerNowSize = 0 // 크기 추적용
    while (true) {
        val info = br.readLine().toInt()
        when (info) {
            -1 -> break
            0 -> {
                if (router.isNotEmpty()) { // 버퍼가 비어있을 때 0이 입력으로 안 들어온다고는 하지만 넣어봄
                    router.poll()
                    routerNowSize--
                }
            }

            else -> {
                if (routerNowSize == n) {
                    continue
                } else {
                    router.add(info)
                    routerNowSize++
                }
            }
        }
    }
    if (router.isNotEmpty()) {
        println(router.joinToString(" "))
    } else {
        println("empty")
    }

}