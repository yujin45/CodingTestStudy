package org.example

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    if (N == 1) {
        // 뒤의 reduce는 요소 2개 이상이어야 해서&빠른 return
        println(abs(br.readLine().toInt() - S))
        return
    }

    val st = StringTokenizer(br.readLine())
    val differ = IntArray(N)

    for (i in 0 until N) {
        val now = st.nextToken().toInt()
        differ[i] = abs(S - now)
    }
    //println(differ.contentToString())

    //println(differ.reduce(::gcd))
    //val gcdDiffer = differ.reduce { acc, num -> gcd(acc, num) } // differ 요소가 2개 이상이어야 함
    val gcdDiffer = differ.fold(differ[0]) { acc, num -> gcd(acc, num) }
    println(gcdDiffer)
    br.close()
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

