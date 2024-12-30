fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val list = ArrayList<Pair<Int, Int>>()
    for(i in 0 until n){
        val (x, y) = br.readLine().split(" ").map{it.toInt()}
        list.add(Pair(x, y))
    }
    list.sortWith(compareBy({it.first}, {it.second}))
    for(l in list){
        sb.append("${l.first} ${l.second}\n")
    }
    println(sb.toString())
}