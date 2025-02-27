package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val room = Array(N) { br.readLine() } // 문자열 배열로 입력 받기

    var horizontal = 0 // 가로 누울 자리 개수
    var vertical = 0 // 세로 누울 자리 개수
    // 가로 방향 탐색
    for (i in 0 until N) {
        var count = 0 // 연속된 빈 공간 개수
        for (j in 0 until N) {
            if (room[i][j] == '.') {
                count++
            } else {
                if (count >= 2) horizontal++
                count = 0
            }
        }
        if (count >= 2) horizontal++ // 마지막 칸까지 빈 공간이면 체크
    }
    // 세로 방향 탐색
    for (j in 0 until N) {
        var count = 0
        for (i in 0 until N) {
            if (room[i][j] == '.') {
                count++
            } else {
                if (count >= 2) vertical++
                count = 0
            }
        }
        if (count >= 2) vertical++ // 마지막 칸까지 빈 공간이면 체크
    }

    println("$horizontal $vertical")
    br.close()
}
