package org.example

import java.util.StringTokenizer

data class Student(val name: String, val dd: Int, val mm: Int, val yyyy: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array<Student>(n) {
        val st = StringTokenizer(br.readLine())
        Student(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedWith(compareBy<Student> { it.yyyy }.thenBy { it.mm }.thenBy { it.dd })
    // 나이 많은 순 정렬
    println(arr[arr.lastIndex].name)
    println(arr[0].name)
    br.close()
}
