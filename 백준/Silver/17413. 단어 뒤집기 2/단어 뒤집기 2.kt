package org.example

import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val stack = Stack<Char>()
    var flag = false
    val userInput = br.readLine()
    for(i in 0 until userInput.length){
        val userInputChar = userInput[i]
        if(userInputChar == '<'){
            while(!stack.isEmpty()){
                sb.append(stack.pop())
            }
            sb.append(userInputChar)
            flag = true
        }else if(userInputChar == '>'){
            sb.append(userInputChar)
            flag = false
        }else if(flag){
            sb.append(userInputChar)
        }else if(!flag && userInputChar == ' '){
            while(!stack.isEmpty()){
                sb.append(stack.pop())
            }
            sb.append(userInputChar)
        }else{
            stack.push(userInputChar)
        }
    }
    while(!stack.isEmpty()){
        sb.append(stack.pop())
    }
    println(sb)
}