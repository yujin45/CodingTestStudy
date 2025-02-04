package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val people = mutableListOf<Pair<Int, String>>()
    repeat(n) {
        val (age, name) = br.readLine().split(" ")
        people.add(age.toInt() to name)
    }
    people.sortWith(compareBy({ it.first }))
    for ((age, name) in people) {
        sb.append(age).append(" ").append(name).append("\n")
    }
    println(sb)
    br.close()
}