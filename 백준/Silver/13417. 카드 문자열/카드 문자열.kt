package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val alphaList = br.readLine().split(" ")

        val ret = ArrayDeque<String>()

        var minChar = alphaList[0]
        ret.add(minChar)
        for (i in 1 until n) {
            if (minChar >= alphaList[i]) {
                minChar = alphaList[i]
                ret.addFirst(alphaList[i])
            } else {
                ret.add(alphaList[i])
            }
        }
        sb.append("${ret.joinToString("")}\n")
    }
    print(sb)
    br.close()
}