package org.example

import java.util.LinkedList

fun main(){
    val br = System.`in`.bufferedReader()
    val (n, w, L) = br.readLine().split(" ").map{it.toInt()}
    val trucks = LinkedList(br.readLine().split(" ").map{it.toInt()})

    var time = 0
    var bridgeWeight = 0
    val bridge = LinkedList((0 until w).map{0})

    while(trucks.isNotEmpty() || bridgeWeight > 0){
        // 트럭 남거나 다리 0되기 전까지 수행
        time++
        val exitedTruck = bridge.poll() // 다리에서 빼고
        bridgeWeight -= exitedTruck

        if(trucks.isNotEmpty() && bridgeWeight + trucks.first() <= L){
            // 적재 가능
            val nextTruck = trucks.poll()
            bridge.add(nextTruck)
            bridgeWeight += nextTruck
        }else{
            // 적재 불가능
            bridge.add(0)
        }
    }
    println(time)

}