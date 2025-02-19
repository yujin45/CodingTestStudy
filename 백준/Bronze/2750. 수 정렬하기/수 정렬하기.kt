fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr = IntArray(N)
    repeat(N) {
        arr[it] = br.readLine().toInt()
    }
    arr.sort()
    val sb = StringBuilder()
    arr.forEach {
        sb.append(it).append("\n")
    }
    println(sb)
    br.close()
}