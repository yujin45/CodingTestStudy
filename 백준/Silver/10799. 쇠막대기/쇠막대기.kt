
import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val stack = Stack<Char>()
    val pipes = br.readLine()
    var ret = 0
    for(i in 0 until pipes.length){
        if(pipes[i]=='('){
            stack.push('(')
        }else{
            stack.pop()
            if(pipes[i-1]==')'){
               ret += 1
            }else{
                ret += stack.size
            }
        }
    }
    println(ret)
}