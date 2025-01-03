

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    val stack = Stack<String>()

    for(i in 0 until n){
        val commands = br.readLine()
        when{
            commands.startsWith("push") -> {
                val (_, num) = commands.split(" ")
                stack.push(num)
            }
            commands.startsWith("pop") -> {
                if(stack.isEmpty()){
                    sb.append("-1\n")
                }else{
                    sb.append("${stack.pop()}\n")
                }
            }
            commands.startsWith("size")->{
                sb.append("${stack.size}\n")
            }
            commands.startsWith("empty")->{
                if(stack.isEmpty()){
                    sb.append("1\n")
                }else{
                    sb.append("0\n")
                }
            }
            commands.startsWith("top")->{
                if (stack.isEmpty()){
                    sb.append("-1\n")
                }else{
                    sb.append("${stack.peek()}\n")
                }
            }
        }

    }
    println(sb)

}
