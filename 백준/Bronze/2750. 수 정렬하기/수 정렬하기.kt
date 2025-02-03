package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val nums = IntArray(n)
    repeat(n) {
        nums[it] = br.readLine().toInt()
    }
    nums.sort()
    nums.forEach {
        sb.append("$it\n")
    }
    print(sb)
    br.close()
}
