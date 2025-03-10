package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val num = br.readLine()
    // k개 지워서 얻을 수 있는 가장 큰 수
    // num의 앞에서부터 넣는데, 더 큰게 들어오면 지우고 지운 것이 k개 되면 다 넣기

    val stack = StringBuilder()
    var deleteCount = 0
    for (n in num) {
        while (stack.isNotEmpty() && deleteCount < K) {
            if (stack.last() < n) {
                stack.deleteCharAt(stack.length - 1)
                deleteCount++
            } else {
                break
            }
        }
        stack.append(n)
    }
    // 만약에 다 돌았는데 deleteCount가 아직 K가 아니면 뒤에서부터 제거해주기
    while (stack.isNotEmpty() && deleteCount < K) {
        stack.deleteCharAt(stack.length - 1)
        deleteCount++
    }
    println(stack)
    br.close()
}
