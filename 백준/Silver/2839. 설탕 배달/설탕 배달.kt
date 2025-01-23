package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    var count = 0
    var sucess = false
    while (n >= 0) {
        if (n % 5 == 0) {
            count += n / 5
            println(count)
            sucess = true
            break
        }
        n -= 3
        count++
    }
    if (!sucess) {
        println(-1)
    }

    br.close()
}

