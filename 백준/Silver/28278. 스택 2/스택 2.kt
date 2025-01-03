
import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    val stack = Stack<String>()
    for(i in 0 until n){
        val user_input = br.readLine()
        when{
            user_input.startsWith("1")->{
                val (_, num) = user_input.split(" ")
                stack.push(num)
            }
            user_input.startsWith("2")->{
                if(stack.isEmpty()){
                    sb.append("-1\n")
                }else {
                    sb.append("${stack.pop()}\n")
                }
            }
            user_input.startsWith("3")->{
                sb.append("${stack.size}\n")
            }
            user_input.startsWith("4")->{
                if (stack.isEmpty()){
                    sb.append("1\n")
                }else{
                    sb.append("0\n")
                }
            }
            user_input.startsWith("5")->{
                if(stack.isEmpty()){
                    sb.append("-1\n")
                }else{
                    sb.append("${stack.peek()}\n")
                }
            }
        }
    }
    println(sb)
}