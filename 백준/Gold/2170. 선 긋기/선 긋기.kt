package org.example

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val lines = ArrayList<Pair<Int, Int>>()
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        lines.add(st.nextToken().toInt() to st.nextToken().toInt())
    }
    lines.sortBy { it.first }

    // 시작점 기준으로 정렬해주고

    var nowStart = lines[0].first
    var nowEnd = lines[0].second
    var linesLength = 0

    // 순회하면서 확인해주기
    for (i in 1 until n) {
        val (start, end) = lines[i]
        if (start > nowEnd) {// 새로운 구간 시작
            linesLength += nowEnd - nowStart
            nowStart = start
            nowEnd = end
        } else { // 기존 구간과 겹침
            nowEnd = maxOf(nowEnd, end) // 끝나는 위치 업데이트

        }
    }
    linesLength += (nowEnd - nowStart)
    //println(count) // 앗차 덩어리 개수를 구해버렸군.
    println(linesLength)

    br.close()
}