package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, kim, lim) = br.readLine().split(" ").map { it.toInt() }

    println(tornamentQ(n, kim, lim))
    br.close()
}

fun tornamentQ(n: Int, kim: Int, lim: Int): Int {
    var roundCount = 0
    var queueA = ArrayDeque<Int>()
    var queueB = ArrayDeque<Int>()
    (1..n).forEach {
        queueA.add(it)
    }

    while (queueA.size > 1) {
        // 1명 남을 때까지 진행
        roundCount++
        while (queueA.isNotEmpty()) {
            // 비어 있지 않음녀
            if (queueA.size > 1) {
                // 2명이면
                val p1 = queueA.removeFirst()
                val p2 = queueA.removeFirst()
                if ((p1 == kim && p2 == lim) || (p1 == lim && p2 == kim)) {
                    return roundCount
                } else if (p1 == kim || p1 == lim) {
                    queueB.addLast(p1)
                } else {
                    queueB.addLast(p2)
                }

            } else {
                // 홀수여서 1명 남으면 넣기
                queueB.add(queueA.removeFirst())
            }
        }
        var temp = queueA
        queueA = queueB
        queueB = temp
    }


    return roundCount
}
