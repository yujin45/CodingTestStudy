package org.example

import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val stack = Stack<Char>()
    var ret = 0
    val n = br.readLine().toInt()
    repeat(n) {
        val userInput = br.readLine()

        if(userInput.length%2==1) return@repeat
        stack.clear()
        for(c in userInput){
            if(stack.isEmpty()) stack.push(c)
            else if(stack.peek() == c) stack.pop()
            else stack.push(c)
        }

        if(stack.isEmpty()) ret++
    }
    println(ret)
}