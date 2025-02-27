package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    var (N, a, b) = br.readLine().split(" ").map { it.toInt() }
    // 서로 번호가 같아지면 경쟁하는 라운드
    // 다음 라운드 번호는 (현재 i + 1) /2 로 결정됨
    var count = 0
    while (a != b) {
        a = (a + 1) / 2
        b = (b + 1) / 2
        count++
    }
    println(count)
    br.close()
}
