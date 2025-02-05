package org.example

import java.util.StringTokenizer

data class Birthday(val name: String, val day: Int, val month: Int, val year: Int)

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val birthdays = Array<Birthday>(n) {
        val st = StringTokenizer(br.readLine())
        Birthday(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
    }
    birthdays.sortWith(compareBy({ it.year }, { it.month }, { it.day }))
    println("${birthdays[n - 1].name}\n${birthdays[0].name}")
    br.close()
}