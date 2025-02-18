package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = IntArray(n)
    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }
    arr.sort()
    //println(arr.contentToString())
    val x = br.readLine().toInt()
    var start = 0
    var end = n - 1
    var count = 0
    while (start < end) {
        val check = arr[start] + arr[end]
        if (check < x) { // x보다 작으면 start를 오른쪽으로 이동
            start++
        } else if (check > x) { // x보다 크면 end를 왼쪽으로 이동
            end--
        } else {
            // 값이 같으면 카운트 증가 후 start를 오른쪽으로 이동
            count++
            start++
        }
    }
    println(count)
    br.close()
}