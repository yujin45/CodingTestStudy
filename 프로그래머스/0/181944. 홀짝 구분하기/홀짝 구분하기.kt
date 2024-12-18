fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    
    val num = br.readLine().toInt()
    if(num % 2 == 0){bw.write("${num} is even")}
    else{bw.write("${num} is odd")}

    
    
    bw.flush()
    br.close()
    bw.close()
    
}