fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map {it.toInt()}
    val textSet = HashSet<String>()
    repeat(n){
        textSet.add(br.readLine())
    }

    var count  = 0
    repeat(m){
        if(br.readLine() in textSet){
            count++
        }
    }
    bw.write(count.toString())
    br.close()
    bw.flush()
    bw.close()
}
