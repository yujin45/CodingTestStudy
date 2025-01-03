
import java.util.Stack

fun main(){
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val numList = IntArray(n)
    val stack = Stack<Int>()
    var current = 1

    repeat(n) {
        numList[it] = br.readLine().toInt()
    }
    //println(numList.contentToString())
    for(num in numList){
        // current가 더 커지면 진행불가
        while(current <= num){
            stack.push(current)
            sb.append("+\n")
            current++
        }
        if(stack.peek() == num){
            stack.pop()
            sb.append("-\n")
        }else{
            println("NO")
            System.exit(0)
        }
    }
    println(sb)


}