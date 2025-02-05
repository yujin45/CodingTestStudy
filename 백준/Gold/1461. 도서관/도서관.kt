package org.example

import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val books = br.readLine().split(" ").map { it.toInt() }

    // 음수와 양수 분리 후 정렬
    val negatives = books.filter { it < 0 }.sorted()
    val positives = books.filter { it > 0 }.sortedDescending()

    var totalDistance = 0
    val maxDistance = maxOf(negatives.firstOrNull()?.absoluteValue ?: 0, positives.firstOrNull()?.absoluteValue ?: 0)

    // 음수 그룹 이동
    for (i in negatives.indices step m) {
        totalDistance += negatives[i].absoluteValue * 2
    }

    // 양수 그룹 이동
    for (i in positives.indices step m) {
        totalDistance += positives[i].absoluteValue * 2
    }

    // 최장 거리 편도 적용
    println(totalDistance - maxDistance)

    br.close()

}