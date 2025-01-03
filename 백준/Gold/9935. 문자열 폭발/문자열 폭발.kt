package org.example

fun main(){
    val br = System.`in`.bufferedReader()
    var stack = StringBuilder()
    val original = br.readLine()
    val boom = br.readLine()
    val boomSize = boom.length
    val boomLast = boom.last()

    for(char in original){
        stack.append(char)
        if(char == boomLast && stack.length >=boomSize){
            if(stack.substring(stack.length-boomSize)==boom){
                stack.delete(stack.length - boomSize, stack.length) // 슬라이싱 삭제
            }
            
        }
    }

    if (stack.isEmpty()) {
        println("FRULA")
    } else {
        println(stack.toString())
    }
}