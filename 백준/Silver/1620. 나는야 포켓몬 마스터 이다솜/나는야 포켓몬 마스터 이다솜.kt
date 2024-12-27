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


    for(i in 0 until m){
        val userInput = br.readLine()
        userInput.toIntOrNull()?.let {
            sb.append(num_name[userInput.toInt()])
            sb.append('\n')
        } ?: run{
            sb.append(name_num[userInput])
            sb.append('\n')
        }
    }
    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}
