package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map{it.toInt()}

    val num_name = Array<String>(n+1){""}
    val name_num = HashMap<String, Int>()

    for(i in 1..n){
        val name = br.readLine()
        num_name[i] = name
        name_num[name] = i
    }

    repeat(m){
        val userInput = br.readLine()
        if(userInput[0].isDigit()){
            // 첫번째 글자만 숫자인지 판단해줘도 됨
            sb.append(num_name[userInput.toInt()]).append('\n')
        }else{
            sb.append(name_num[userInput]).append('\n')
        }
    }

    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}
