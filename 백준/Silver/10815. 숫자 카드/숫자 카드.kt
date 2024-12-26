
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    
    val N = br.readLine()
    val cards = HashSet(br.readLine().split(" "))
    val M = br.readLine()
    val checkCards = br.readLine().split(" ")

    for(card in checkCards){
        if(card in cards){
            sb.append("1 ")
        }else{
            sb.append("0 ")
        }
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}
