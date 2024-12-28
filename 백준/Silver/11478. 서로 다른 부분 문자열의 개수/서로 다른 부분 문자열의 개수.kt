
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val s = br.readLine()
    val n = s.length
    val hashSet = hashSetOf<String>()
    for(i in 0 until n){
        for(j in (i+1) until (n+1)){
            hashSet.add(s.substring(i, j))
        }
    }
    bw.write("${hashSet.size}")
    bw.flush()
    br.close()
    bw.close()

}