package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    val T = StringBuilder(br.readLine())

    while (T.length > S.length) {
        if (T.last() == 'A') {
            T.deleteCharAt(T.lastIndex) // dropLast() 대신 StringBuilder 사용
        } else {
            T.deleteCharAt(T.lastIndex).reverse() // reversed() 대신 StringBuilder 사용
        }
    }

    println(if (S == T.toString()) 1 else 0) // 최종 비교
    br.close()
}
