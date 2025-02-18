package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B) = br.readLine().split(" ").map { it.toInt() }
    val stA = StringTokenizer(br.readLine())
    val stB = StringTokenizer(br.readLine())
    val aHashSet = HashSet<String>()
    val bHashSet = HashSet<String>()
    repeat(A) {
        aHashSet.add(stA.nextToken())
    }
    repeat(B) {
        bHashSet.add(stB.nextToken())
    }
    // 대칭 차집합 개수만 구하면 됨
    var count = 0
    for (e in aHashSet) {
        if (!bHashSet.contains(e)) count++
    }
    // 아래처럼 하는 방법도 있음
    for (e in bHashSet) {
        if (e !in aHashSet) count++
    }
    println(count)
    br.close()
}