package org.example

import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()

    // 입력
    val n = br.readLine().toInt()
    val numbers = IntArray(n)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        numbers[i] = st.nextToken().toInt()
    }
    val x = br.readLine().toInt()
    // 

    val seen = mutableSetOf<Int>() // 등장한 숫자 저장
    var count = 0

    for (num in numbers) {
        if ((x - num) in seen) {
            // x에서 num 뺀 것이 존재한다면 쌍이 존재하는 것 (num, x-num)
            count++
        }
        seen.add(num) // 현재 숫자를 set에 추가
    }
    
    println(count)
    br.close()
}


