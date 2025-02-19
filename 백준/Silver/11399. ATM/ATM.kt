package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = mutableListOf<Int>()
    repeat(N){
        arr.add(st.nextToken().toInt())
    }
    arr.sort()
    var result = 0
    //println(arr)
    for(i in 0 until N){
        result += arr[i]*(N-i)
    }
    println(result)
    br.close()
}