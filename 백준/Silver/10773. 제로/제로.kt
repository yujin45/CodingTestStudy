
import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val stack = Stack<Int>()
    val n = br.readLine().toInt()

    for(i in 0 until n){
        val num = br.readLine().toInt()
        if(num == 0){
            stack.pop()
        }else{
            stack.push(num)
        }
    }

    println(stack.sum())
}