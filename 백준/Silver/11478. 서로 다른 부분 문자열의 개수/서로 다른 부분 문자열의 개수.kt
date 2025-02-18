fun main() {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    val hashSet = HashSet<String>()
    var count = 0
    for (step in 1..S.length) {
        for (i in 0..S.length - step) {
            hashSet.add(S.substring(i, i + step))
        }
        count += hashSet.size
        hashSet.clear()
    }
    println(count)
    br.close()
}