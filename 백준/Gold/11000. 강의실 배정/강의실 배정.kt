package org.example

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val lecture = mutableListOf<Pair<Int, Int>>()
    repeat(N) {
        val st = StringTokenizer(br.readLine())
        lecture.add(st.nextToken().toInt() to st.nextToken().toInt())
    }
    lecture.sortBy { it.first } // 시작 시간 빠른 것으로
    val room = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // 빨리 끝나는 것을 우선으로
    room.add(lecture[0])
    for (i in 1 until N) {
        val nowRoom = room.poll()
        if (nowRoom.second > lecture[i].first) {// 시작 시간 보다 크면 다른 강의실 만들어야 함
            room.add(nowRoom) // 재활용
        }
        room.add(lecture[i])
    }
    println(room.size)

    br.close()
}
