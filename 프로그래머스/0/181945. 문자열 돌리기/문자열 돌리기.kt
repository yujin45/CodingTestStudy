fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    
    val text = br.readLine()
    text.forEach{char -> 
        bw.write("${char}\n")
    }
    
    bw.flush()
    br.close()
    bw.close()
    
}