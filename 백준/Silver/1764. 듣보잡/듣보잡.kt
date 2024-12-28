fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val ret = arrayListOf<String>()
    val hashMap = HashMap<String, Int>()
    for( i in 0 until n){
        hashMap[br.readLine()] = 1
    }

    for(i in 0 until m){
        val name = br.readLine()
        if(hashMap.containsKey(name)){
            ret.add(name)
        }
    }
    ret.sort()
    bw.write(ret.size.toString()+"\n")
    bw.write(ret.joinToString("\n"))

    br.close()
    bw.flush()
    bw.close()
}
