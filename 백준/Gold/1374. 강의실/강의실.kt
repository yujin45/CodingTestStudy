package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    // 최대한 적은 수 => 강의실 배정 문제
    // 강의실이 여러개이기 때문에 시작 시간 빠른 것 우선으로 넣어두고 이후 종료시간 빠른 순
    val lectures = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
    val room = PriorityQueue<Int>()
    repeat(N) {
        val st = StringTokenizer(br.readLine())
        st.nextToken() // 강의 번호는 필요 없음
        lectures.add(st.nextToken().toInt() to st.nextToken().toInt())
    }

    room.add(lectures.poll().second)
    while (lectures.isNotEmpty()) {
        val (start, end) = lectures.poll()
        val curRoomEnd = room.poll()
        if (start < curRoomEnd) {
            room.add(curRoomEnd) // 새 강의실 오픈이 필요할 때 기존 다시 넣기
        }
        room.add(end)
    }
    println(room.size)
    br.close()
}