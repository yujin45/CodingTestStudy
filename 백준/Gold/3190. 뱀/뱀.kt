package org.example

import java.util.LinkedList

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n){IntArray(n){0}}

    val k = br.readLine().toInt()

    repeat(k) {
        val (ax, ay) = br.readLine().split(" ").map{it.toInt()}
        board[ax-1][ay-1] = 1 // 사과 표시
    }

    val L = br.readLine().toInt()
    val turnDict = hashMapOf<Int, String>()
    repeat(L){
        val (X, C) = br.readLine().split(" ")
        turnDict[X.toInt()]=C
    }

    var time = 0
    val bam = LinkedList<Pair<Int, Int>>()
    var dx = 0
    var dy = 1
    var cx = 0
    var cy = 0
    board[cx][cy] = 2 // 뱀 시작 위치
    bam.add(cx to cy)
    while(true){
        time++

        val nx = cx + dx
        val ny = cy + dy

        if(0<= nx && nx <n && 0<= ny && ny <n && board[nx][ny] != 2){
            // 벽 아니고 자기 자신 아니면
            if(board[nx][ny] != 1){
                // 사과 없으면 꼬리 이동
                val (bx, by) = bam.poll()
                board[bx][by] = 0
            }
            cx = nx
            cy = ny
            board[cx][cy] = 2
            bam.add(cx to cy)
        }else{
            println(time)
            break
        }

        if(time in turnDict){
            if(turnDict[time] == "L"){
                val temp = dx
                dx = -dy
                dy = temp
            }else{
                val temp = dx
                dx = dy
                dy = -temp
            }
        }
    }

}