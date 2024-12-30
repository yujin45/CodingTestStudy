package org.example


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val intArray = IntArray(n)
    for(i in 0 until n){
        intArray[i] = br.readLine().toInt()
    }
    intArray.sort()
    for(num in intArray) {
        bw.write("$num\n")
    }
    br.close()
    bw.flush()
    bw.close()
}