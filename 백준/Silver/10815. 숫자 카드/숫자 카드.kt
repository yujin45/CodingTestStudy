fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val N = br.readLine()
    val cards = br.readLine().split(" ").map{ it.toInt()}.toSet()
    val M = br.readLine()
    val checkCards = br.readLine().split(" ").map{it.toInt()}
    
    for(card in checkCards){
        if(card in cards){
            bw.write("1 ")
        }else{
            bw.write("0 ")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}