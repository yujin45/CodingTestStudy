package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        var st: StringTokenizer
        val candidate = IntArray(n)
        for (i in 0 until n) {
            st = StringTokenizer(br.readLine())
            // 정렬 대신 서류 순위로 인덱싱을 해둘 수도 있음!!
            candidate[st.nextToken().toInt() - 1] = st.nextToken().toInt()
        }

        // 서류 순서로 정렬하고 검사해주기
        //println(candidate)
        var mScore = candidate[0] // 1위의 면접 순위를 가져오기
        var count = 1
        for (i in 1 until n) {
            //println("${candidate[i][1]} - ${mScore}")
            if (candidate[i] < mScore) {
                count++
                mScore = candidate[i]// 업데이트
            }
        }
        sb.append(count).append("\n")
    }
    print(sb)
    br.close()
}