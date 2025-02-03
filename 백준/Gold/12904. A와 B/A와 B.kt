package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val T = StringBuilder()
    val S = br.readLine()
    T.append(br.readLine())

    var isAble = false
    // 아이디어!!! : 거꾸로 생각하기
    while (T.length >= S.length) {
        if (T.toString() == S) {
            isAble = true
            break
        }
        if (T.last() == 'A') {
            // 마지막이 A면 # 문자열의 뒤에 A를 추가한다.# 연산을 한 것
            T.deleteCharAt(T.lastIndex)
        } else if (T.last() == 'B') {
            // 마지막이 B면 # 문자열 뒤집고 뒤에 B 추가 # 연산을 한 것
            T.deleteCharAt(T.lastIndex)
            T.reverse()
        }
    }

    println(if (isAble) 1 else 0)
    br.close()
}
