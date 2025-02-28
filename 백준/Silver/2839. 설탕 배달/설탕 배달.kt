package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    // 5a + 3b = N
    // a+b가 최소가 되도록 해라
    var x = N / 5 // 5kg 봉지 개수 최대로 사용

    while (x >= 0) {
        val remaining = N - (x * 5) // 남은 무게
        if (remaining % 3 == 0) {
            // 3kg봉지로 정확히 나눌 수 있으면
            val y = remaining / 3
            println(x + y)
            return
        }
        x-- // 5kg 봉지 줄이고 다시 시도
    }
    println(-1) // 못나누는 경우
    br.close()
}
