fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t){
        val (a, b) = br.readLine().split(" ").map{it.toInt()}
        bw.write("${a+b}\n")
    }
    bw.flush()
    br.close()
    bw.close()
}