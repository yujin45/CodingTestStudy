package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    // 올바른 탐색 범위 시작점 계산
    for (k in maxOf(1, n - n.toString().length * 9) until n) {
        if ((k + k.toString().map { it.digitToInt() }.sum()) == n) {
            println("$k")
            br.close()
            return
        }
    }

    // 생성자가 없을 경우
    println(0)
    br.close()
}
