

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val list = ArrayList<Int>()

    for(i in 0 until n) {
        list.add(br.readLine().toInt())
    }

   list.sort()
    for(num in list){
        sb.appendLine(num)
    }
    println(sb.toString())
}