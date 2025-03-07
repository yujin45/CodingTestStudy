package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

data class Homework(val d: Int, val w: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val homeworks = Array<Homework>(n) {
        val st = StringTokenizer(br.readLine())
        Homework(st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedBy { it.d } // 마감일 빠른 것 우선 보기 
    val pq = PriorityQueue<Int>()
    // 기간 내에 할 수 있는 일을 담아두고, 낮은 과제 우선 제거, pq의 사이즈가 곧 n일의 분량인 것!!

    for (homework in homeworks) {
        pq.add(homework.w) // 현재 과제 추가
        if (pq.size > homework.d) {
            // 현재 과제의 데드라인이 n일을 넘어가면 과제 비용 낮은거 제거
            pq.poll()
        }
    }
    println(pq.sum())
    br.close()
}
