package org.example

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val N = br.readLine().toInt()
    val stN = StringTokenizer(br.readLine())
    // Int를 키값으로 둬도 되지만, 숫자로만 주어지므로 String으로 비교 가능
    val hashMap = HashMap<String, Int>()
    repeat(N) {
        val num = stN.nextToken()
        hashMap[num] = hashMap.getOrDefault(num, 0) + 1
    }
    val M = br.readLine().toInt()
    val stM = StringTokenizer(br.readLine())
    repeat(M) {
        val num = stM.nextToken()
        if (hashMap.containsKey(num)) {
            sb.append(hashMap.getValue(num)).append(" ")
        } else {
            sb.append(0).append(" ")
        }

    }
    sb.deleteCharAt(sb.length - 1)
    println(sb)
    br.close()
}