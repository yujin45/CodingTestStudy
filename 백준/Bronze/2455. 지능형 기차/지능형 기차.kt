package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    var maxPeople = Int.MIN_VALUE
    var current = 0
    repeat(4) {
        val (off, on) = br.readLine().split(" ").map { it.toInt() }
        current += (-off + on)
        maxPeople = maxOf(maxPeople, current)
    }
    println(maxPeople)
    br.close()
}
