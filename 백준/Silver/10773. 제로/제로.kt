
fun main() {
    val br = System.`in`.bufferedReader()
    val K = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    repeat(K) {
        val num = br.readLine().toInt()
        if (num == 0) {
            stack.removeLast()
        } else {
            stack.add(num)
        }
    }
    var sum: Long = stack.fold(0) { acc, it -> acc + it }
    print(sum)
    br.close()
}
