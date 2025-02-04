package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val sensors = br.readLine().split(" ").map { it.toInt() }.sorted()

    // ★ 만약 k>= n이면 모든 센서를 커버하는 집중국이 가능하므로 비용 = 0
    if (k >= n) {
        println(0)
        return
    }
    //println(sensors)
    // n개의 센서 k개 집중국 - 유치원 문제와 비슷한듯함.
    val diff = IntArray(n - 1)
    for (i in 0 until n - 1) {
        diff[i] = sensors[i + 1] - sensors[i]
    }
    diff.sort()
    println(diff.take(n - k).sum())
    br.close()
}