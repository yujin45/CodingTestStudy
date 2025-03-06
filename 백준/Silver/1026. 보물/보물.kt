package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.sorted()
    val B = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    // A만 재배열 - B를 기준으로 정렬하면 될 것 같은데
    // B를 재배열하면 안된다고 했으나 이는 속임수! 어차피 우리는 S의 최소값만 구하면 된다!
    // 그러기 위해서는 A 오름차순 X B 내림차순으로 해주면 되는 것
    var sum = 0
    for (i in 0 until n) {
        sum += A[i] * B[i]
    }
    println(sum)
    br.close()
}