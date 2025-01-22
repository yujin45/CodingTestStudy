package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, kim, lim) = br.readLine().split(" ").map { it.toInt() }
    println(tornament(kim, lim))
    br.close()
}

fun tornament(kim: Int, lim: Int): Int {
    var roundCount = 0
    var kim = kim
    var lim = lim
    while (kim != lim) {
        kim = (kim + 1) / 2
        lim = (lim + 1) / 2
        roundCount++
    }
    return roundCount
}