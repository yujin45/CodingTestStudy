package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    val N = br.readLine().toInt()
    val stN = StringTokenizer(br.readLine())
    val hashSet = HashSet<String>()
    repeat(N) {
        hashSet.add(stN.nextToken())
    }
    val M = br.readLine().toInt()
    val stM = StringTokenizer(br.readLine())
    repeat(M) {
        if (hashSet.contains(stM.nextToken())) sb.append(1).append("\n")
        else sb.append(0).append("\n")
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}