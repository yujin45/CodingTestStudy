package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    // 길이 N으로 같은 문자열 x, y
    // x, y의 차이 => 위치상 불일치 요소
    val st = StringTokenizer(br.readLine())
    val A = st.nextToken()
    val B = st.nextToken()
    // A.length <=B.length
    // A를 B랑 밀면서 확인 필요 // 뭔가 문자열 비교 알고리즘 쓰면 더 빠르겠지만, 모르겠으므로 for문 쓸 예정
    val diffLen = B.length - A.length + 1
    var diffCount = 0
    var minDiffCount = 50
    for (d in 0 until diffLen) {
        for (i in A.indices) {
            if (A[i] != B[i + d]) {
                diffCount++
            }
        }
        minDiffCount = minOf(minDiffCount, diffCount)
        diffCount = 0
    }
    println(minDiffCount)
    br.close()
}
