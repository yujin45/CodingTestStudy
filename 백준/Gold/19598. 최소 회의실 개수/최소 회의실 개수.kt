package org.example

import java.util.StringTokenizer
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val meetings = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
    repeat(N) {
        val st = StringTokenizer(br.readLine())
        meetings.add(st.nextToken().toInt() to st.nextToken().toInt())
    }
    val room = PriorityQueue<Int>()
    room.add(meetings.poll().second)
    while (meetings.isNotEmpty()) {
        val (start, end) = meetings.poll()
        val curRoomEnd = room.poll()
        if (start < curRoomEnd) {
            room.add(curRoomEnd)
        }
        room.add(end)
    }
    println(room.size)
    br.close()
}
