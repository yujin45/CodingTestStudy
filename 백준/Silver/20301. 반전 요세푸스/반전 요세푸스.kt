package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, k, m) = br.readLine().split(" ").map { it.toInt() }
    val queue = ArrayDeque<Int>((1..n).toList())
    val ret = mutableListOf<Int>()

    var isRight = true
    while (queue.isNotEmpty()) {
        if (isRight) {
            // 정방향 진행
            // 앞의 k-1개 빼서 뒤로 넣기
            repeat((k - 1) % queue.size) {
                queue.addLast(queue.removeFirst())
            }
        } else {
            // 반대방향 진행
            // 제거된 것 기준 고려
            repeat(k % queue.size) {
                queue.addFirst(queue.removeLast())
            }
        }
        ret.add(queue.removeFirst())
        if (ret.size % m == 0) {
            // m명 제거되면 방향 전환
            isRight = !isRight
        }
    }
    for (r in ret) {
        sb.append("$r\n")
    }
    print(sb)

}