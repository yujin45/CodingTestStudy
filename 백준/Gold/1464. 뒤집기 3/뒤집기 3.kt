package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    // i만큼 뒤집 => [0, i) 문자 역순으로 뒤집기
    // 1~N 차례대로 생각 , 뒤집 안 뒤집 생각
    val deque = ArrayDeque<Char>()
    for (c in S) {
        // 사전 순 비교해서 앞에 넣을지 뒤에 넣을지 결정
        if (deque.isEmpty() || c > deque.first()) {
            // 비어있거나, 제일 앞의 것보다 c가 더 큰거면 뒤에 추가
            deque.addLast(c)
        } else {
            deque.addFirst(c) // 사전순으로 더 작다면 앞에 추가
        }
        //println(deque)
    }
    // 결과 추가
    val sb = StringBuilder()
    deque.forEach { sb.append(it) }
    println(sb)
    br.close()
}


