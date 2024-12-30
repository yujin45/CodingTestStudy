
fun main() {
    val br = System.`in`.bufferedReader()
    val nums = br.readLine().map{it.digitToInt()}.sortedDescending()
    print(nums.joinToString(""))
}