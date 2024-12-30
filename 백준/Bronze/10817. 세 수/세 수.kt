
fun main() {
    val br = System.`in`.bufferedReader()
    val nums = br.readLine().split(" ").map{it.toInt()}.sorted()
    println(nums[1])
}