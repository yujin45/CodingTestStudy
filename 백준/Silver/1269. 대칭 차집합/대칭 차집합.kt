fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (a, b) = br.readLine().split(" ")
    val aSet = HashSet<Int>(br.readLine().split(" ").map { it.toInt() })
    val bSet = HashSet<Int>(br.readLine().split(" ").map { it.toInt() })

    var count = 0
    for(element in aSet){
        if(element !in bSet) count++
    }
    for(element in bSet){
        if(element !in aSet) count++
    }
    bw.write("$count")
    bw.flush()
    br.close()
    bw.close()

}