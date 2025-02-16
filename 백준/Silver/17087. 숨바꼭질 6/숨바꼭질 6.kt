package org.example

import java.util.StringTokenizer
import kotlin.math.absoluteValue


fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    if (N == 1) {
        println((br.readLine().toInt() - S).absoluteValue)
        return
    }
    val A = IntArray(N)
    val st = StringTokenizer(br.readLine())
    repeat(N) {
        A[it] = (st.nextToken().toInt() - S).absoluteValue
    }
    //println(A.contentToString())
    val gcdA = A.reduce { acc, num -> gcd(acc, num) }
    println(gcdA)

    br.close()
}
