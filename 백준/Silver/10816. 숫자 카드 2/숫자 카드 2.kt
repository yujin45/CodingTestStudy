fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val map = HashMap<String, Int>()
    val having = br.readLine().split(" ")

    for(h in having){
        val cValue = map[h] ?: 0
        map.put(h, cValue+1)
    }

    val m = br.readLine().toInt()
    val checkCards = br.readLine().split(" ")
    for(i in 0 until m){
        if(map.containsKey(checkCards[i])){
            sb.append(map[checkCards[i]])
            sb.append(" ")
        }else{
            sb.append("0 ")
        }
    }
    bw.write(sb.toString())

    br.close()
    bw.flush()
    bw.close()
}
