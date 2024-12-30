fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map{it.toInt()}.sorted()
    var ret = 0
    for(i in 0 until n){
        ret += list[i]*(n-i)
    }
    println(ret)
}