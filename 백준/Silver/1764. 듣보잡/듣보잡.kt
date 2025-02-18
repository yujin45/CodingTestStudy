
fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val notHear = HashSet<String>()
    val notHearSee = mutableListOf<String>()
    repeat(N) {
        notHear.add(br.readLine())
    }
    repeat(M) {
        val see = br.readLine()
        if (notHear.contains(see)) {
            notHearSee.add(see)
        }
    }
    notHearSee.sort()
    sb.append(notHearSee.size).append("\n")
    notHearSee.forEach { sb.append(it).append("\n") }
    print(sb)
    br.close()
}