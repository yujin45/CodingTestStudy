
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val set = HashSet<String>()
    repeat(n) {
        val (name, state) = br.readLine().split(" ")
        if (state == "enter"){
            set.add(name)
        }else{
            set.remove(name)
        }
    }
    
    val sortedList = set.sortedDescending()
    for(name in sortedList){
        sb.append(name).append("\n")
    }
    bw.write(sb.toString())
    br.close()
    bw.flush()
    bw.close()
}
