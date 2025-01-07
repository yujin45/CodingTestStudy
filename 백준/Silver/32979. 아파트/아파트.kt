package org.example

fun main(){
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val t = br.readLine().toInt()
    val handsApartement = br.readLine().split(" ").map{it.toInt()}
    val b_list = br.readLine().split(" ").map{it.toInt()}
    var index = 0
    val sb = StringBuilder()
    for(b in b_list){
        index = (index+(b-1)) % handsApartement.size
        sb.append("${handsApartement[index]} ")
    }
    println(sb)
}