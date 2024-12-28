
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (a, b) = br.readLine().split(" ")
    val aSet = HashSet<Int>(br.readLine().split(" ").map { it.toInt() })
    val bSet = HashSet<Int>(br.readLine().split(" ").map { it.toInt() })

    val c = aSet.union(bSet) - aSet.intersect(bSet)
    bw.write("${c.size}")
    bw.flush()
    br.close()
    bw.close()

}