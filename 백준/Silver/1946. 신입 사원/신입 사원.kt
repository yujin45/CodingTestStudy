package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val candidate = Array(n) { br.readLine().split(" ").map { it.toInt() } }
            .sortedWith(compareBy({ it[0] }))
        // 서류 순서로 정렬하고 검사해주기
        //println(candidate)
        var mScore = candidate[0][1] // 1위의 면접 순위를 가져오기
        var count = 1
        for (i in 1 until n) {
            //println("${candidate[i][1]} - ${mScore}")
            if (candidate[i][1] < mScore) {
                count++
                mScore = candidate[i][1] // 업데이트
            }
        }
        sb.append(count).append("\n")
    }
    print(sb)
    br.close()
}