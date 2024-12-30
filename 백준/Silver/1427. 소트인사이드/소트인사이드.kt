fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val nums = br.readLine().map{it.digitToInt()}.sortedDescending()
    for(n in nums){
        sb.append("$n")
    }
    print(sb.toString())
}