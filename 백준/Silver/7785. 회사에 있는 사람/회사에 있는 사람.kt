fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

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

    for(name in set.sortedDescending()){
        bw.write(name)
        bw.write("\n")
    }
    br.close()
    bw.flush()
    bw.close()
}
