fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val nSet = br.readLine().split(" ").map{it.toInt()}.toHashSet()
    val m = br.readLine().toInt()
    val mList = br.readLine().split(" ").map{it.toInt()}
    for(e in mList){
        if(e in nSet){
            sb.appendLine("1")
        }else{
            sb.appendLine("0")
        }
    }
    print(sb.toString())
}