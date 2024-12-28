fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val mset = mutableSetOf<String>()
    val ret = mutableListOf<String>()

    for( i in 0 until n){
        mset.add(br.readLine())
    }

    for(i in 0 until m){
        val name = br.readLine()
        if(mset.contains(name)){
            ret.add(name)
        }
    }
    ret.sort()
    sb.append("${ret.size}\n")
    for(r in ret){
        sb.append("$r\n")
    }

    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}
