package org.example

import java.util.PriorityQueue
import java.util.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()

    // 입력 처리
    val (n, m) = br.readLine().split(" ").map{it.toInt()}
    val parkingPrice = IntArray(n){br.readLine().toInt()} // 주차 공간 별 요금
    val carWeights = IntArray(m+1) // 차량 무게 (번호가 1~n이어서 0은 안 쓰고 둠)
    for(i in 1..m){
        carWeights[i] = br.readLine().toInt()
    }

    // 주차 상태 관리
    val availableSpaces = PriorityQueue<Int>() // 빈 공간 번호 관리
    for(i in 0 until n){
        availableSpaces.add(i)
    }
    val parking = IntArray(n){-1} // 주차 공간 상태 (-1: 빈 상태)
    val waitingQueue = ArrayDeque<Int>() // 대기 차량
    var totalPrice = 0

    // 차량 입출력 처리
    repeat(2*m){
        val order = br.readLine().toInt()

        if(order >0 ){ // 차량 입장
            if(availableSpaces.isNotEmpty()){
                // 빈 공간이 있는 경우
                val space = availableSpaces.poll()
                parking[space] = order
                totalPrice += parkingPrice[space] * carWeights[order]
            }else {
                // 빈 공간이 없는 경우 대기
                waitingQueue.add(order)
            }
        }else{
            // 차량 퇴장
            val car = -order
            for(i in 0 until n){
                if(parking[i] == car){
                    parking[i] = -1 // 공간 비우기
                    availableSpaces.add(i) // 빈 공간 추가
                    break
                }
            }
            // 대기 차량 처리
            if (waitingQueue.isNotEmpty() && availableSpaces.isNotEmpty()){
                val space = availableSpaces.poll()
                val nextCar= waitingQueue.poll()
                parking[space] = nextCar
                totalPrice += parkingPrice[space] * carWeights[nextCar]
            }
        }
    }
    // 결과 출력
    println(totalPrice)
}