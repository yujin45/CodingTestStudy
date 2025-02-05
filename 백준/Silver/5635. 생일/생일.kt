package org.example

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val birthdays = ArrayList<Array<Any>>()
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        birthdays.add(arrayOf(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()))
    }

    val sortedBirthdays =
        birthdays.sortedWith(compareBy<Array<Any>>({ -(it[3] as Int) }, { -(it[2] as Int) }, { -(it[1] as Int) }))
   

    println("${sortedBirthdays[0][0]}\n${sortedBirthdays[n - 1][0]}")
    br.close()
}