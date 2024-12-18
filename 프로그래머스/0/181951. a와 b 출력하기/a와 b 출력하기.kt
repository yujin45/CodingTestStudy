fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    
    val (a, b) = br.readLine().split(" ")
    bw.write("a = ${a}\nb = ${b}\n")
    bw.flush()
    
    br.close()
    bw.close()
}