package org.example

import java.util.StringTokenizer
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
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
        numbers.sort()
        //println(numbers.contentToString())
        val makeNumbers = IntArray(n)
        var index = n - 1
        for (i in 0 until n) {
            if (i % 2 == 0) {
                makeNumbers[i / 2] = numbers[i]
            } else {
                makeNumbers[index] = numbers[i]
                index--
            }
        }
        //println(makeNumbers.contentToString())
        // numbers 배열 재활용하기
        for (i in 0 until n - 1) {
            numbers[i] = (makeNumbers[i + 1] - makeNumbers[i]).absoluteValue
        }
        numbers[n - 1] = (makeNumbers[n - 1] - makeNumbers[0]).absoluteValue
        //println(numbers.contentToString())
        //println(numbers.max())
        sb.append(numbers.max()).append("\n")
    }
    println(sb)
    br.close()
}