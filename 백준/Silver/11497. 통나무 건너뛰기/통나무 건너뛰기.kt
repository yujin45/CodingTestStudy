package org.example

import java.util.StringTokenizer
import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val numbers = IntArray(n)
        val st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            numbers[i] = st.nextToken().toInt()
        }
        numbers.sort() // 오름차순 정렬

        val makeNumbers = IntArray(n) // 가장 차이 적게 배치하는 것
        var index = n - 1
        for (i in 0 until n) {
            if (i % 2 == 0) {
                // 짝수면 앞에서부터 채워넣음
                makeNumbers[i / 2] = numbers[i]
            } else {
                makeNumbers[index] = numbers[i]
                index-- // 홀수면 뒤에서부터 채워넣음
            }
        }

        // numbers 배열 재활용해서 차이값 넣기
        for (i in 0 until n - 1) {
            numbers[i] = (makeNumbers[i + 1] - makeNumbers[i]).absoluteValue
        }
        numbers[n - 1] = (makeNumbers[n - 1] - makeNumbers[0]).absoluteValue
        sb.append(numbers.max()).append("\n")
    }
    print(sb)
    br.close()
}
