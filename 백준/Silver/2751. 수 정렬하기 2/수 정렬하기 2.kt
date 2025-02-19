package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val numbers = MutableList(br.readLine().toInt()){br.readLine().toInt()}
    numbers.sort()
    numbers.forEach{bw.write("$it\n")}
    bw.flush()
    bw.close()
    br.close()
}