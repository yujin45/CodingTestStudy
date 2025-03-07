package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    // 가장 먼 곳은 되돌아오지 않을 곳 && 먼저 방문한다 생각하고 계산
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val leftBooks = PriorityQueue<Int>(compareByDescending { it }) // 음수 값들 넣어줄 용도
    val rightBooks = PriorityQueue<Int>(compareByDescending { it }) // 양수 값들 넣어줄 용도

    val st = StringTokenizer(br.readLine())
    repeat(N) {
        val book = st.nextToken().toInt()
        if (book < 0) {
            leftBooks.add(-book)
        } else {
            rightBooks.add(book)
        }
    }

    val maxLen: Int
    if (leftBooks.isNotEmpty() && rightBooks.isEmpty()) {
        maxLen = leftBooks.first()
    } else if (leftBooks.isEmpty() && rightBooks.isNotEmpty()) {
        maxLen = rightBooks.first()
    } else {
        maxLen = if (leftBooks.first() > rightBooks.first()) leftBooks.first() else rightBooks.first()
    }


    var totalLen = -maxLen
    var i = 0
    while (leftBooks.isNotEmpty()) {
        val book = leftBooks.poll()
        if (i % M == 0) {
            totalLen += book * 2
            //println("book: $book - totalLen : $totalLen")
        }
        i++
    }
    i = 0
    while (rightBooks.isNotEmpty()) {
        val book = rightBooks.poll()
        if (i % M == 0) {
            totalLen += book * 2
            //println("book: $book - totalLen : $totalLen")
        }
        i++
    }
    println(totalLen)
    br.close()
}
