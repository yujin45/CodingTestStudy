
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()
    val nums = br.readLine().toCharArray().sortedByDescending { it }.forEach { sb.append(it) }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}