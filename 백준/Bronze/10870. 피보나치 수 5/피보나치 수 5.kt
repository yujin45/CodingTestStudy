package org.example

fun fib(num: Int): Int {
    if (num < 2) {
        return num
    }
    return fib(num - 1) + fib(num - 2)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toInt()
    println(fib(num))
    br.close()
}
